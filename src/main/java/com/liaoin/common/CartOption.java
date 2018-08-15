package com.liaoin.common;

import com.liaoin.entity.ProductList;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

// 商品细节描述类  具体商品, 数量, ...
@Data
public class CartOption implements Serializable {

    private ProductList productList;  // 商品信息
    private BigDecimal num; // 数量
    private BigDecimal amount;

}
