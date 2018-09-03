package com.sankuai.headcount.repositories;

public class HCRepository {

    public HCEntitySnapshot getCurrentDepartment() throws InnerException {
        try {
            //communicate with db,cache or filesystem...
        } catch (Exception ex) {
            throw new InnerException(ex, CauseEnum.SQL,  CauseEnum.SQL.getMessage());
        }
    }
}