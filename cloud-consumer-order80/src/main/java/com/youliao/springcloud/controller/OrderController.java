package com.youliao.springcloud.controller;


import com.youliao.springcloud.entities.CommonResult;
import com.youliao.springcloud.entities.Payment;
import com.youliao.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author Dali
 * @Date 30/6/2021 下午 12:17
 * @Version 1.0
 * @Description
 */
@RestController
@Slf4j
public class OrderController {
    //    public static final String PAYMENT_URL = "http://localhost:8001";
    //public static final String PAYMENT_URL = "http://cloud-payment-service";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; //为了与@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", ...)的name大小写保持一致


    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        //postForObject/ postForEntity的区别：
        //return restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class).getBody();
    }

    /**
     * getForObject：返回对象为响应体中数据转化成的对象，基本可以理解为Json。
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/   " + id, CommonResult.class);
    }

    /**
     * getForEntity:返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/   " + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info("***日志信息***" + entity.getStatusCode() + "\t" + entity.getHeaders());  //可以获取到一些信息，比如：响应状态码、响应头
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    /**
     * 自己写的负载均衡 轮询算法
     *
     * @return
     */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}


















