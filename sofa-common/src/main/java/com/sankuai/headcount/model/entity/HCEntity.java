package com.sankuai.headcount.model.entity;

import com.sankuai.headcount.model.FSMState;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

/**
 * @author luoqi04
 */
@Data
public class HCEntity {

    @Getter
    private Long identifier;
    @Getter
    private Long hcNumber;
    @Getter
    private FSMState.Phase state;
    @Getter
    private Date createTime;
    @Getter
    private Date modifyTime;
}
