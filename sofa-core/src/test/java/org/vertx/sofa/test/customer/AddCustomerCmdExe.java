package org.vertx.sofa.test.customer;

import org.vertx.sofa.command.Command;
import org.vertx.sofa.command.CommandExecutorI;
import org.vertx.sofa.dto.Response;
import org.vertx.sofa.extension.ExtensionExecutor;
import org.vertx.sofa.logger.Logger;
import org.vertx.sofa.logger.LoggerFactory;
import org.vertx.sofa.test.customer.convertor.CustomerConvertorExtPt;
import org.vertx.sofa.test.customer.entity.CustomerEntity;
import org.vertx.sofa.test.customer.validator.extensionpoint.AddCustomerValidatorExtPt;
import org.vertx.sofa.validator.ValidatorExecutor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AddCustomerCmdExe
 *
 * @author Frank Zhang 2018-01-06 7:48 PM
 */
@Command
public class AddCustomerCmdExe implements CommandExecutorI<Response, AddCustomerCmd> {

    private Logger logger = LoggerFactory.getLogger(AddCustomerCmd.class);

    @Autowired
    private ValidatorExecutor validatorExecutor;

    @Autowired
    private ExtensionExecutor extensionExecutor;


    @Override
    public Response execute(AddCustomerCmd cmd) {
        logger.info("Start processing command:" + cmd);
        validatorExecutor.validate(AddCustomerValidatorExtPt.class, cmd);

        //Convert CO to Entity
        CustomerEntity customerEntity = extensionExecutor.execute(CustomerConvertorExtPt.class, extension -> extension.clientToEntity(cmd.getCustomerCO()));

        //Call Domain Entity for business logic processing
        logger.info("Call Domain Entity for business logic processing..."+customerEntity);
        customerEntity.addNewCustomer();

        logger.info("End processing command:" + cmd);
        return Response.buildSuccess();
    }
}
