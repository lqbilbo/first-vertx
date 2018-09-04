package com.sankuai.headcount.query;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

/**
 * @author luoqi04
 */
@Data
public class HCEntitySnapshot {

    @Getter
    private Long id;
    @Getter
    private Long hcNumber;
    @Getter
    private Integer state;
    @Getter
    private Integer departId;
    @Getter
    private Date effTime;
    @Getter
    private Date createTime;
    @Getter
    private Date modifyTime;
}
