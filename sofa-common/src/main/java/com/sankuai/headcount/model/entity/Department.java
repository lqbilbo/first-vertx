package com.sankuai.headcount.model.entity;

import lombok.Data;
import lombok.Getter;

/**
 * @author luoqi04
 */
@Data
public class Department {

    @Getter
    private Long identifier;
    @Getter
    private String name;
}
