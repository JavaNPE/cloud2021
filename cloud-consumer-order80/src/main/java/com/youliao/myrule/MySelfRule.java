package com.youliao.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Dali
 * @Date 3/7/2021 下午 6:49
 * @Version 1.0
 * @Description MySelfRule规则类
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();  //定为 “随机” 负载规则算法
    }
}
