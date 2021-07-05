package com.youliao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author Dali
 * @Date 2/7/2021 下午 10:03
 * @Version 1.0
 * @Description
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "springcloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
