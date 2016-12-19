package com.chen.dao;

import com.chen.entity.Customer;

public interface CustomerDao {
    public Customer getCustomerByName(String firstName); 
}
