package com.youliao.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2021-06-29 07:11:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = 408627485948961889L;
    /**
     * ID
     */
    private Long id;

    private String serial;
}