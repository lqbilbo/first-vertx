package com.sankuai.headcount.service;

import java.util.Date;

@Component
public class ValidateService {

    @Resource
    private Repository repository;

    public boolean ifEffTimeEarlyThanOrNow(Date effTime) {
        if (effTime.compareOf(new Date()) <= 0) {
            return true;
        }
        return false;
    }

    public boolean ifDepartmentChanged(HCEntity currentHc) {
        Department department = currentHc.getDepartment();
        if (repository.getCurrentDepartment().equals(department.getId())) {
            return true;
        }
        return false;
    }
}