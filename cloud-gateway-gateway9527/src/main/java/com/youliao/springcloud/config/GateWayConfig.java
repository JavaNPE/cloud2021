package com.youliao.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Dali
 * @Date 2021/07/11 下午 3:25
 * @Version 1.0
 * @Description
 */
@Configuration
public class GateWayConfig {
    // 配置了一个id为route-name的路由规则，当访问地址 http://localhost:9527/guonei时，会自动转发到
    // 地址 http;//news.baidu.com/guonei

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_rote_atguigu", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

}
