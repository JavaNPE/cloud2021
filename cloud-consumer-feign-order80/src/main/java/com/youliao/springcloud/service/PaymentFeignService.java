package com.youliao.springcloud.service;

import com.youliao.springcloud.entities.CommonResult;
import com.youliao.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Dali
 * @Date 2021/07/05 下午 12:44
 * @Version 1.0
 * @Description
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //value："微服务名称"
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
}
