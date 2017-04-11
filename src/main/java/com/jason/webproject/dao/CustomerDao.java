package com.jason.webproject.dao;


import com.jason.webproject.model.Customer;

/**
 * Created by Jason on 4/11/17.
 */
public interface CustomerDao
{
    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
}