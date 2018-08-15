package com.liaoin.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Waybill implements Serializable {


    //运单编号
    private String waybillId;

    //快递公司
    private String expressCompany;

    //订单
    private Order order;

    //是否删除：1删除", hidden = true
    private String isDelete;

}
