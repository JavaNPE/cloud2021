package com.youliao.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Dali
 * @Date 2021/8/3 11:20
 * @Version 1.0
 * @Description
 */
@Configuration
@MapperScan({"com.youliao.springcloud.alibaba.dao"})
public class MyBatisConfig {

}
