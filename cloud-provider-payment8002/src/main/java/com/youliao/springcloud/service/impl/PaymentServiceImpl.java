package com.youliao.springcloud.service.impl;
import com.youliao.springcloud.dao.PaymentDao;
import com.youliao.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import com.youliao.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * (Payment)表服务实现类
 *
 * @author makejava
 * @since 2021-06-29 08:03:07
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}