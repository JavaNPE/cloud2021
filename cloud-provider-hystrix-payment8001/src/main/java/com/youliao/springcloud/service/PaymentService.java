package com.youliao.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author Dali
 * @Date 2021/07/06 下午 6:28
 * @Version 1.0
 * @Description
 */
@Service
public class PaymentService {
    /**
     * 正常访问 肯定ok
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_OK,id：  " + id + "\t" + "哈哈哈";
    }

    //服务降级：3秒以内走正常的逻辑，（业务逻辑需要5秒）超过3秒，则出现超时的错误，我们走兜底方案：paymentInfo_TimeOutHandler
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")  //峰值：3秒
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5; //业务逻辑需要5秒，
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOut,id：  " + id + "\t" + "呜呜呜" + " 耗时(秒)" + timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   系统繁忙或者运行报错,请稍后再试,id：  " + id + "\t" + "/(ㄒoㄒ)/~~";

    }

}
