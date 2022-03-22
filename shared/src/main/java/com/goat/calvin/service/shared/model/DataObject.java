package com.goat.calvin.service.shared.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 *
 * @author yangrong
 * @date 2019/8/17 13:51
 */
@Data
@Accessors(chain = true)
public class DataObject {

    /**
     * 总数
     */
    private Integer total;

    /**
     * 环比
     */
    private String chainRatio;

    /**
     * 同比
     */
    private String sameRatio;
}
