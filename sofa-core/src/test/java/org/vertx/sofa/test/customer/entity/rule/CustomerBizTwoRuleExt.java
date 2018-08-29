package org.vertx.sofa.test.customer.entity.rule;

import org.vertx.sofa.extension.Extension;
import org.vertx.sofa.test.customer.Constants;
import org.vertx.sofa.test.customer.entity.CustomerEntity;

/**
 * CustomerBizTwoRuleExt
 *
 * @author Frank Zhang
 * @date 2018-01-07 12:10 PM
 */
@Extension(bizCode = Constants.BIZ_2)
public class CustomerBizTwoRuleExt implements CustomerRuleExtPt{

    @Override
    public boolean addCustomerCheck(CustomerEntity customerEntity) {
        //Any Customer can be added
        return true;
    }
}
