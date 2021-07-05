package com.youliao.springcloud.controller;

import com.youliao.springcloud.entities.CommonResult;
import com.youliao.springcloud.entities.Payment;
import com.youliao.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Dali
 * @Date 2021/07/05 下午 1:19
 * @Version 1.0
 * @Description
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign的底层是ribbon，客户端（也就是我们的消费者）一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
