package com.liaoin.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liaoin.common.Result;
import com.liaoin.entity.Order;
import com.liaoin.entity.User;
import com.liaoin.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 17:23 2018/8/2
 * @Description:
 */
@RestController
@Api(value = "订单模块",description = "OrderController",tags = "订单模块")
public class OrderController {

    private static final String NOT_PAY1 = "1";

    private static final String NOT_PAY2= "2";
    private static final String NOT_PAY3= "3";
    private static final String NOT_PAY4= "4";

    @Autowired
    private OrderService orderService;

    @ApiOperation("查询订单")
    @GetMapping("/selectOrderByPrimaryKey")
    @ApiImplicitParam(name = "orderId", value = "订单编号", dataType = "String", paramType = "query", required = true)
    public Result selectOrderByPrimaryKey(@RequestParam String id) {
        Order order = orderService.selectOrderByPrimaryKey(id);
        if (order== null){
            return new Result(300,"没有此订单",null);
        }
        return new Result(200, "查询成功", order);
    }

    @ApiOperation("删除订单")
    @PostMapping("/deleteOrderByPrimaryKey")
    public Result deleteOrderByPrimaryKey(@RequestBody String id) {
        Integer order = orderService.deleteOrderByPrimaryKey(id);
        return new Result(200, "删除成功", order);
    }
    @ApiOperation("添加订单")
    @PostMapping("/insertOrder")
    public Result insertOrder(@RequestBody Order record) {
        int i = orderService.insertOrder(record);
        return new Result(200, "添加成功", i);
    }
    @ApiOperation("修改订单")
    @PostMapping("/updateOrderByPrimaryKey")
    public Result updateOrderByPrimaryKey(@RequestBody Order record) {
        int i = orderService.updateOrderByPrimaryKey(record);
        return new Result(200, "修改成功", i);
    }

    @ApiOperation(value = "订单分页", notes = "订单分页")
    @RequestMapping(value = "/orderGet", method = RequestMethod.GET)
    public Result orderGet(@RequestParam Integer page, @RequestParam Integer size) {
        //分页并查询
        Page<Order> pageInfo = PageHelper.startPage(page, size);
        List<Order> orders = orderService.listOrder();
        //获取分页信息演示
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<Order> result = pageInfo.getResult();//和上面的users结果相同
        return new Result(200,"分页成功",pageInfo);
    }
    @GetMapping("/check")
    @ApiOperation("校验订单状态")
    @ApiImplicitParam(name = "id", value = "订单编号", dataType = "String", paramType = "query", required = true)
    public Result check(HttpSession session, @RequestParam String id) {
        //校验用户是否登录
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return new Result(300, "请登录", null);
        }
        //检验订单编号是否存在
        Order order = orderService.selectOrderByPrimaryKey(id);
        if (order == null) {
            return new Result(300,"订单不存在",null);
        }
        //校验订单状态是否合法
        if (NOT_PAY1.equals(order.getStatus())) {
            return new Result(300,"订单未付款",null);
        }
        if (NOT_PAY2.equals(order.getStatus())) {
            return new Result(300,"订单还未发货",order);
        }
        //校验用户和订单是否匹配
        if (!order.getUser().equals(loginUser)) {
            return new Result(300, "非当前用户订单", null);
        }
        return new Result(200, "订单已经付款", order);
    }

    @PostMapping("/submit")
    @ApiOperation("提交订单")
    public Result submit(HttpSession session, @RequestParam Order order) {
        // 1.用户是否登录
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return new Result(300, "请登录", null);
        }
        Result submit = orderService.submit(loginUser, order, session);
        return new Result(200,"提交成功",submit);
    }

}
