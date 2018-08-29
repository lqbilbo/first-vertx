/*
 * Copyright 2017 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package org.vertx.sofa.extension;

import org.vertx.sofa.boot.ComponentExecutor;
import org.vertx.sofa.common.CoreConstant;
import org.vertx.sofa.common.DefaultBizCode;
import org.vertx.sofa.context.TenantContext;
import org.vertx.sofa.exception.InfraException;
import org.vertx.sofa.logger.Logger;
import org.vertx.sofa.logger.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ExtensionExecutor 
 * @author fulan.zjf 2017-11-05
 */
@Component
public class ExtensionExecutor extends ComponentExecutor{

    private Logger logger = LoggerFactory.getLogger(ExtensionExecutor.class);

    @Autowired
    private ExtensionRepository extensionRepository;

    @Override
    protected <C> C locateComponent(Class<C> targetClz) {
        C extension = locateExtension(targetClz);
        logger.debug("[Located Extension]: "+extension.getClass().getSimpleName());
        return locateExtension(targetClz);
    }

    /**
     * @param targetClz
     */
    @SuppressWarnings("unchecked")
    protected <Ext> Ext locateExtension(Class<Ext> targetClz) {
        String bizCode = TenantContext.getBizCode();
        String tenantId = TenantContext.getTenantId();
        ExtensionCoordinate extensionCoordinate = new ExtensionCoordinate(targetClz.getSimpleName(), bizCode, tenantId);
        /**
         * 1.First search key is: extensionPoint + bizCode + tenantId
         */
        Ext extension = (Ext)extensionRepository.getExtensionRepo().get(extensionCoordinate);
        if (extension != null) {
            return extension;
        }
        /**
         * 2.Second search key is: extensionPoint + bizCode
         */        
        extensionCoordinate.setTenantId(CoreConstant.DEFAULT_TENANT_ID);
        extension = (Ext)extensionRepository.getExtensionRepo().get(extensionCoordinate);
        if (extension != null) {
            return extension;
        }  
        /**
         * 3.Third search key is: extensionPoint
         */
        extensionCoordinate.setBizCode(DefaultBizCode.DEFAULT_BIZ_CODE);
        extension = (Ext)extensionRepository.getExtensionRepo().get(extensionCoordinate);
        if (extension != null) {
            return extension;
        }          
        throw new InfraException("Can not find extension for ExtensionPoint: "+targetClz);
    }
}
