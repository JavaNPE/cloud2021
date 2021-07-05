package com.youliao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Dali
 * @Date 2021/07/04 下午 10:40
 * @Version 1.0
 * @Description: Ribbon之手写轮询算法
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        // 自旋锁
        do {
            // 获取当前值
            current = this.atomicInteger.get();

            /*2147483647:整型最大值*/
            // 发生越界，从0开始计数
            next = current >= 2147483647 ? 0 : current + 1;
            // 比较并交换
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*****第几次访问，次数next: " + next);
        return next;
    }


    //负载均衡算法：第几次请求%服务器总数量=实际访问。服务每次启动从1开始
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        // 获取当前计数 模  实例总数
        int index = getAndIncrement() % serviceInstances.size();
        // 返回选择的实例
        return serviceInstances.get(index);
    }
}
