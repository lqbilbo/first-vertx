package org.vertx.sofa.test.customer.interceptor;

import org.vertx.sofa.command.CommandInterceptorI;
import org.vertx.sofa.command.PreInterceptor;
import org.vertx.sofa.dto.Command;
import org.vertx.sofa.exception.ParamException;
import org.vertx.sofa.validator.SofaMessageInterpolator;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * ValidationInterceptor
 *
 * @author Frank Zhang 2018-01-06 8:27 PM
 */
@PreInterceptor
public class ValidationInterceptor implements CommandInterceptorI {

    //Enable fail fast, which will improve performance
    private ValidatorFactory factory = Validation.byProvider(HibernateValidator.class).configure().failFast(true)
            .messageInterpolator(new SofaMessageInterpolator()).buildValidatorFactory();

    @Override
    public void preIntercept(Command command) {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Command>> constraintViolations = validator.validate(command);
        constraintViolations.forEach(violation -> {
            throw new ParamException(violation.getPropertyPath() + " " + violation.getMessage());
        });
    }
}