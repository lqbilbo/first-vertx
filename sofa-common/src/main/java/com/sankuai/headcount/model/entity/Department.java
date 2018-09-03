package com.sankuai.headcount.model.entity;

import com.sankuai.headcount.model.FSMState;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

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
