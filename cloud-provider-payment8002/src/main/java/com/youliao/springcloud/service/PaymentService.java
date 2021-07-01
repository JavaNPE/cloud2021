package com.youliao.springcloud.service;

import com.youliao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * (Payment)表服务接口
 *
 * @author makejava
 * @since 2021-06-29 07:59:33
 */
public interface PaymentService {


    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    int create(Payment payment);


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Payment getPaymentById(@Param("id") Long id);
}