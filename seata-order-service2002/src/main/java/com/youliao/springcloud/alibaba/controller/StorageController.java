package com.youliao.springcloud.alibaba.controller;

import com.youliao.springcloud.alibaba.domain.CommonResult;
import com.youliao.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Dali
 * @Date 2021/8/3 10:45
 * @Version 1.0
 * @Description
 */

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    //扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功！");
    }
}

