package com.sankuai.headcount.service;

import com.sankuai.headcount.model.entity.Department;
import com.sankuai.headcount.model.entity.HCEntity;
import com.sankuai.headcount.model.exception.InnerException;
import com.sankuai.headcount.repositories.HCRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class ValidateService {

    @Resource
    private HCRepository repository;

    public boolean ifEffTimeEarlyThanOrNow(Date effTime) {
        if (effTime.compareTo(new Date()) <= 0) {
            return true;
        }
        return false;
    }

    public boolean ifDepartmentChanged(HCEntity currentHc) {
        try {
            Department department = currentHc.getDepartment();
            if (repository.getCurrentDepartment().getDepartId().equals(department.getIdentifier())) {
                return true;
            }
        } catch (InnerException ex) {
          //ignore
        }
        return false;
    }

    public boolean ifKeyFieldsChanged(HCEntity hcEntity) {
        //iterators
        return false;
    }
}