package com.sankuai.headcount.model;

import com.sankuai.headcount.model.valObj.JobFamily;
import com.sankuai.headcount.model.valObj.JobGroup;
import lombok.Data;
import lombok.Getter;

/**
 * @author luoqi04
 */
@Data
public class Employee {

    @Getter
    private Integer empId;
    @Getter
    private String empName;
    @Getter
    private JobFamily jobFamily;
    @Getter
    private JobGroup jobGroup;
    @Getter
    private String jobLevel;


}
