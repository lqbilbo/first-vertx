package org.vertx.sofa.test.customer;

import org.vertx.sofa.repository.DataObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * CustomerDO
 *
 * @author Frank Zhang
 * @date 2018-01-08 1:45 PM
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerDO implements DataObject {
    private String customerId;
    private String memberId;
    private String globalId;
    private String companyName;
    private String source;
    private String companyType;
}