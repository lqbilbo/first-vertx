package org.vertx.sofa.test.customer.validator.extension;

import org.vertx.sofa.exception.ParamException;
import org.vertx.sofa.extension.Extension;
import org.vertx.sofa.test.customer.AddCustomerCmd;
import org.vertx.sofa.test.customer.Constants;
import org.vertx.sofa.test.customer.validator.extensionpoint.AddCustomerValidatorExtPt;

/**
 * AddCustomerBizTwoValidator
 *
 * @author Frank Zhang
 * @date 2018-01-07 1:31 AM
 */
@Extension(bizCode = Constants.BIZ_2)
public class AddCustomerBizTwoValidator implements AddCustomerValidatorExtPt{

    @Override
    public void validate(Object candidate) {
        AddCustomerCmd addCustomerCmd = (AddCustomerCmd) candidate;
        //For BIZ TWO CustomerTYpe could not be null
        if (addCustomerCmd.getCustomerCO().getCustomerType() == null)
            throw new ParamException("CustomerType could not be null");
    }
}
