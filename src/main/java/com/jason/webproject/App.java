package com.jason.webproject;

import com.jason.webproject.dao.CustomerDao;
import com.jason.webproject.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Jason on 4/11/17.
 */
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("webproject/applicationContext.xml");

        CustomerDao customerDAO = (CustomerDao) context.getBean("jdbcCustomerDao");
        Customer customer = new Customer(3, "jason",29);
        customerDAO.insert(customer);

        Customer customer1 = customerDAO.findByCustomerId(1);
        System.out.println(customer1);

    }
}
