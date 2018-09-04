package com.sankuai.headcount.repositories;

import com.sankuai.headcount.model.enums.CauseEnum;
import com.sankuai.headcount.model.exception.InnerException;
import com.sankuai.headcount.query.HCEntitySnapshot;

public class HCRepository {

    public HCEntitySnapshot getCurrentDepartment() throws InnerException {
        try {
            //communicate with db,cache or filesystem...
        } catch (Exception ex) {
            throw new InnerException(ex, CauseEnum.SQL,  CauseEnum.SQL.getMessage());
        }
        return new HCEntitySnapshot();
    }
}