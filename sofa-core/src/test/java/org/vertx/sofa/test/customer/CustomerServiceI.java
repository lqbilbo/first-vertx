package org.vertx.sofa.test.customer;

import org.vertx.sofa.dto.Response;
import org.vertx.sofa.dto.SingleResponse;

/**
 * CustomerServiceI
 *
 * @author Frank Zhang 2018-01-06 7:24 PM
 */
public interface CustomerServiceI {
    public Response addCustomer(AddCustomerCmd addCustomerCmd);
    public SingleResponse<CustomerCO> getCustomer(GetOneCustomerQry getOneCustomerQry);
}
