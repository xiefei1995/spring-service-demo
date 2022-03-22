package com.goat.calvin.service.shared.model.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xiefei15
 * @version 1.0.0
 * @since 2020/11/3 17:48
 */
@Data
@Component
public class Tiger {

    private int age;

    private String name;

    @Autowired
    private Dog dog;
}
