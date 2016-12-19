package com.chen.service.impl;

import com.chen.dao.CustomerDao;
import com.chen.dao.impl.CustomerDaoImpl;
import com.chen.entity.Customer;
import com.chen.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao = new CustomerDaoImpl();
	@Override
	public Customer getCustomer(String firstName) {

		return customerDao.getCustomerByName(firstName);
	}

}
