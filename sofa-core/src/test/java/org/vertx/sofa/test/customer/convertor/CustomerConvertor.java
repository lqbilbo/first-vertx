package org.vertx.sofa.test.customer.convertor;

import org.vertx.sofa.common.ApplicationContextHelper;
import org.vertx.sofa.convertor.ConvertorI;
import org.vertx.sofa.test.customer.CustomerCO;
import org.vertx.sofa.test.customer.CustomerDO;
import org.vertx.sofa.test.customer.entity.CustomerEntity;
import org.vertx.sofa.test.customer.entity.rule.CustomerRuleExtPt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * CustomerConvertor
 *
 * @author Frank Zhang
 * @date 2018-01-07 3:08 AM
 */
@Component
public class CustomerConvertor implements ConvertorI<CustomerCO, CustomerEntity, CustomerDO>{

    @Override
    public CustomerEntity clientToEntity(CustomerCO customerCO){
        CustomerEntity customerEntity = (CustomerEntity)ApplicationContextHelper.getBean(CustomerEntity.class);
        customerEntity.setCompanyName(customerCO.getCompanyName());
        customerEntity.setCustomerType(customerCO.getCustomerType());
        return customerEntity;
    }
}
