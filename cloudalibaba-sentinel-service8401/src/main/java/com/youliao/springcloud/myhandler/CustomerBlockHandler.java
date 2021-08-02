package com.youliao.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.youliao.springcloud.entities.CommonResult;

/**
 * @Author Dali
 * @Date 2021/8/2 11:38
 * @Version 1.0
 * @Description
 */

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----2");
    }
}

