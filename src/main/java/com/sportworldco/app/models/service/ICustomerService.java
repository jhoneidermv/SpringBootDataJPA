package com.sportworldco.app.models.service;

import java.util.List;

import com.sportworldco.app.models.entity.Customer;
import com.sportworldco.app.models.entity.Product;

public interface ICustomerService {
	public List<Customer> findAll();
	public void save(Customer customer);
	public Customer findOne(Long id);
	public void delete(Long id);
	public List<Product> findByName(String term);
}
