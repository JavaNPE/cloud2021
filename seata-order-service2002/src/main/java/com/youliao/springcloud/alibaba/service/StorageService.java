package com.youliao.springcloud.alibaba.service;

/**
 * @Author Dali
 * @Date 2021/8/3 10:42
 * @Version 1.0
 * @Description
 */
public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer count);
}
