package customer.dao;

import customer.model.Customer;

/**
 * Created by Jason on 4/10/17.
 */
public interface CustomerDao
{
    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
}