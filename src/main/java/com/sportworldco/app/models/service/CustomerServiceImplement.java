package com.sportworldco.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportworldco.app.models.dao.ICustomerDao;
import com.sportworldco.app.models.dao.IProductDao;
import com.sportworldco.app.models.entity.Customer;
import com.sportworldco.app.models.entity.Product;

@Service
public class CustomerServiceImplement implements ICustomerService{

	@Autowired
	private ICustomerDao iCustomerDao;
	
	@Autowired
	private IProductDao iProductDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		return (List<Customer>) iCustomerDao.findAll();
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		iCustomerDao.save(customer);
	}

	@Override
	@Transactional(readOnly = true)
	public Customer findOne(Long id) {
		return iCustomerDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		iCustomerDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findByName(String term) {
		return iProductDao.findByName(term);
	}

}
