package org.vertx.sofa.test.customer.entity.rule;

import org.vertx.sofa.extension.ExtensionPointI;
import org.vertx.sofa.rule.RuleI;
import org.vertx.sofa.test.customer.entity.CustomerEntity;

/**
 * CustomerRuleExtPt
 *
 * @author Frank Zhang
 * @date 2018-01-07 12:03 PM
 */
public interface CustomerRuleExtPt extends RuleI, ExtensionPointI{

    //Different business check for different biz
    public boolean addCustomerCheck(CustomerEntity customerEntity);

    //Different upgrade policy for different biz
    default public void customerUpgradePolicy(CustomerEntity customerEntity){
        //Nothing special
    }
}
