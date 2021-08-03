package com.youliao.springcloud.alibaba.domain;

import lombok.Data;

/**
 * @Author Dali
 * @Date 2021/8/3 10:37
 * @Version 1.0
 * @Description
 */
@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}

