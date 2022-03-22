package com.goat.calvin.service.shared.model;


import lombok.Data;

/**
 * @author houxi
 * @version 1.0
 * @date 2020/8/28 16:07
 */
@Data
public class BasePage {
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 每页大小
     */
    private int pageSize;
}
