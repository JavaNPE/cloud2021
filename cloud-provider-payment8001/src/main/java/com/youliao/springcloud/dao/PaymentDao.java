package com.youliao.springcloud.dao;


import com.youliao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.concurrent.locks.Lock;

/**
 * (Payment)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-29 07:23:06
 */
@Mapper
public interface PaymentDao {

    /**
     * 对应 id="create"   parameterType="Payment"
     *
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 读操作
     *
     * @param id
     * @return
     */
    public Payment getPyamentById(@Param("id") Long id);
}