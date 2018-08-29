/*
 * Copyright 2017 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package org.vertx.sofa.extension;

import org.vertx.sofa.common.CoreConstant;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Extension 
 * @author fulan.zjf 2017-11-05
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface Extension {
    String bizCode()  default CoreConstant.DEFAULT_BIZ_CODE;
    String tenantId() default CoreConstant.DEFAULT_TENANT_ID;
}
