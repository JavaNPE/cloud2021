package com.youliao.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Dali
 * @Date 2021/07/24 下午 4:14
 * @Version 1.0
 * @Description
 */
@RestController
@RefreshScope //通过Spring Cloud原生注解@RefreshScope 实现配置自动更新:
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
