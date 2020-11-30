package com.goat.calvin.service.infra.model.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xiefei15
 * @version 1.0.0
 * @since 2020/11/3 17:47
 */
@Data
@Component
public class Dog {

    private int age;

    private String name;

    @Autowired
    private Tiger tiger;
}
