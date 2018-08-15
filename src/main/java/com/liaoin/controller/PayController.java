package com.liaoin.controller;

import com.alipay.api.AlipayApiException;
import com.liaoin.common.OrderConstants;
import com.liaoin.common.Result;
import com.liaoin.entity.Order;
import com.liaoin.entity.SystemAlipay;
import com.liaoin.entity.SystemWxpay;
import com.liaoin.entity.User;
import com.liaoin.service.OrderService;
import com.liaoin.service.PayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * @Author: ldw
 * @Date: created in 15:45 2018/8/14
 * @Description:
 */
@RestController
@Api(value = "支付模块",description = "PayController",tags = "支付模块")
public class PayController {
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;

    @GetMapping("/alipay")
    @ApiOperation("获取订单支付信息，支付宝支付")
    @ApiImplicitParam(name = "orderId", value = "订单编号", dataType = "String", paramType = "query", required = true)
    public Result alipay(HttpSession session, @RequestParam String orderId) throws AlipayApiException {
        // 1.校验用户是否登录
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return new Result(300, "请登录", null);
        }
        // 2.校验支付宝支付系统参数是否加载
        SystemAlipay systemAlipay = (SystemAlipay) servletContext.getAttribute("systemAlipay");
        if (systemAlipay == null) {
           /* logger.info("支付宝支付系统参数异常");*/
            return new Result(300, "系统参数异常", null);
        }
        // 3.校验订单编号是否合法
        Order order = orderService.selectOrderByPrimaryKey(orderId);
        if (order == null) {
            return new Result(300, "订单不存在", null);
        }
        // 4.校验订单状态是否合法
        if (!OrderConstants.NOT_PAY.equals(order.getStatus())) {
            return new Result(300, "订单已付款", null);
        }
        // 5.校验用户和订单是否匹配
        if (!order.getUser().equals(loginUser)) {
            return new Result(300, "非当前用户订单", null);
        }
        String data = payService.alipay(systemAlipay, order);
        return new Result(200, "获取成功", data);
    }

    @GetMapping("/wxpay")
    @ApiOperation("获取订单支付信息，微信支付")
    @ApiImplicitParam(name = "orderId", value = "订单编号", dataType = "String", paramType = "query", required = true)
    public Result wxpay(HttpSession session, @RequestParam String id) throws Exception {
        // 1.校验用户是否登录
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return new Result(300, "请登录", null);
        }
        // 2.校验微信支付系统参数是否加载
        SystemWxpay systemWxpay = (SystemWxpay) servletContext.getAttribute("systemWxpay");
        if (systemWxpay == null) {
            /*logger.info("微信支付系统参数异常");*/
            return new Result(300, "系统参数异常", null);
        }
        // 3.校验订单编号是否合法
        Order order = orderService.selectOrderByPrimaryKey(id);
        if (order == null) {
            return new Result(300, "订单不存在", null);
        }
        // 4.校验订单状态是否合法
        if (!OrderConstants.NOT_PAY.equals(order.getStatus())) {
            return new Result(300, "订单已付款", null);
        }
        // 5.校验用户和订单是否匹配
        if (!order.getUser().equals(loginUser)) {
            return new Result(300, "非当前用户订单", null);
        }
        String data = payService.wxpay(systemWxpay, order);
        return new Result(200, "获取成功", data);
    }

}
