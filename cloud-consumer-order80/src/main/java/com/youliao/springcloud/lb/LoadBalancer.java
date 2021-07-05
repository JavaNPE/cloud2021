package com.youliao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author Dali
 * @Date 2021/07/04 下午 10:36
 * @Version 1.0
 * @Description: 收集Eureka上面所有活着的机器总数 UP (2) - payment8002 , payment8001
 */
public interface LoadBalancer {
    //收集服务器总共有多少台能够提供服务的机器，并放到list里面
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
