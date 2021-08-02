package com.youliao.springcloud.service;

import com.youliao.springcloud.entities.CommonResult;
import com.youliao.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author Dali
 * @Date 2021/8/2 15:04
 * @Version 1.0
 * @Description
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}

