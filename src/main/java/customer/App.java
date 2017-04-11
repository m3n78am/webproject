package customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Jason on 4/10/17.
 */
public class App
{
    public static void main( String[] args )
    {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        CustomerDao customerDAO = (CustomerDao) context.getBean("jdbcCustomerDao");
//        Customer customer = new Customer(2, "jason",29);
//        customerDAO.insert(customer);
//
//        Customer customer1 = customerDAO.findByCustomerId(1);
//        System.out.println(customer1);



        ApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);

        CustomerBo customer = (CustomerBo) context.getBean("customer");
        customer.printMsg("Hello 11");

        SchedulerBo scheduler = (SchedulerBo) context.getBean("scheduler");
        scheduler.printMsg("Hello 22");

    }
}