package com.youliao.springcloud.alibaba.controller;

import com.youliao.springcloud.alibaba.domain.CommonResult;
import com.youliao.springcloud.alibaba.domain.Order;
import com.youliao.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Dali
 * @Date 2021/8/2 22:36
 * @Version 1.0
 * @Description
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}

