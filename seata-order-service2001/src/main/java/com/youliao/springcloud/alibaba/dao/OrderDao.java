package com.youliao.springcloud.alibaba.dao;

import com.youliao.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Dali
 * @Date 2021/8/2 22:26
 * @Version 1.0
 * @Description
 */
@Mapper
public interface OrderDao {
    //新建订单
    void create(Order order);

    //修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}