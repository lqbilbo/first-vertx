package org.vertx.sofa.test.customer.entity.rule;

import org.vertx.sofa.exception.BizException;
import org.vertx.sofa.extension.Extension;
import org.vertx.sofa.test.customer.Constants;
import org.vertx.sofa.test.customer.entity.CustomerEntity;
import org.vertx.sofa.test.customer.entity.SourceType;

/**
 * CustomerBizOneRuleExt
 *
 * @author Frank Zhang
 * @date 2018-01-07 12:10 PM
 */
@Extension(bizCode = Constants.BIZ_1)
public class CustomerBizOneRuleExt implements CustomerRuleExtPt{

    @Override
    public boolean addCustomerCheck(CustomerEntity customerEntity) {
        if(SourceType.AD == customerEntity.getSourceType()){
            throw new BizException("Sorry, Customer from advertisement can not be added in this period");
        }
        return true;
    }
}
