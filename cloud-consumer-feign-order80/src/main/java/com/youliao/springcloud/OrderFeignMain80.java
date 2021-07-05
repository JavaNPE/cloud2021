package com.youliao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Dali
 * @Date 2021/07/05 下午 12:37
 * @Version 1.0
 * @Description
 */
@SpringBootApplication
@EnableFeignClients //使用Feign 激活并开启 激活Feign组件
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
