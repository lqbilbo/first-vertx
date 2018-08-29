package org.vertx.sofa.test.customer.interceptor;

import org.vertx.sofa.command.CommandInterceptorI;
import org.vertx.sofa.command.PreInterceptor;
import org.vertx.sofa.context.TenantContext;
import org.vertx.sofa.dto.Command;
import org.vertx.sofa.test.customer.Constants;

/**
 * ContextInterceptor
 *
 * @author Frank Zhang
 * @date 2018-01-07 1:21 AM
 */
@PreInterceptor
public class ContextInterceptor  implements CommandInterceptorI {

    @Override
    public void preIntercept(Command command) {
        // TenantContext.set(Constants.TENANT_ID, Constants.BIZ_1);
    }
}
