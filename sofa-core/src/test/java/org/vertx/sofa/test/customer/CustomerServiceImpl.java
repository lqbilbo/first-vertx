package org.vertx.sofa.test.customer;

import org.vertx.sofa.command.CommandBusI;
import org.vertx.sofa.dto.Response;
import org.vertx.sofa.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CustomerServiceImpl
 *
 * @author Frank Zhang 2018-01-06 7:40 PM
 */
@Service
public class CustomerServiceImpl implements CustomerServiceI{

    @Autowired
    private CommandBusI commandBus;

    @Override
    public Response addCustomer(AddCustomerCmd addCustomerCmd) {
        return (Response)commandBus.send(addCustomerCmd);
    }

    @Override
    public SingleResponse<CustomerCO> getCustomer(GetOneCustomerQry getOneCustomerQry) {
        return null;
    }
}
