package com.sportworldco.app.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.sportworldco.app.models.entity.Customer;
public interface ICustomerDao extends CrudRepository<Customer, Long>{
	
}
