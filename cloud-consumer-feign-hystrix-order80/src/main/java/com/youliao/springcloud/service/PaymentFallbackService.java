package com.youliao.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author Dali
 * @Date 2021/07/08 上午 11:48
 * @Version 1.0
 * @Description
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,/(ㄒoㄒ)/~~";
    }
}
