package org.vertx.sofa.test.customer.convertor;

import org.vertx.sofa.convertor.ConvertorI;
import org.vertx.sofa.extension.ExtensionPointI;
import org.vertx.sofa.test.customer.CustomerCO;
import org.vertx.sofa.test.customer.entity.CustomerEntity;

/**
 * CustomerConvertorExtPt
 *
 * @author Frank Zhang
 * @date 2018-01-07 2:37 AM
 */
public interface CustomerConvertorExtPt extends ConvertorI, ExtensionPointI {

    public CustomerEntity clientToEntity(CustomerCO customerCO);
}
