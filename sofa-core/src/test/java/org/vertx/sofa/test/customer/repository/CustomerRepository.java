package org.vertx.sofa.test.customer.repository;

import org.vertx.sofa.repository.RepositoryI;
import org.vertx.sofa.test.customer.entity.CustomerEntity;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository
 *
 * @author Frank Zhang
 * @date 2018-01-07 11:59 AM
 */
@Repository
public class CustomerRepository implements RepositoryI {

    public void persist(CustomerEntity customerEntity){
        System.out.println("Persist customer to DB : "+ customerEntity);
    }
}
