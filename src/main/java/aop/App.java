package aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Jason on 4/8/17.
 */
public class App {

    public static void main(String[] args){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("aop-beans.xml");
//
//        Test1Service test1Service = (Test1Service) ac.getBean("test1Service");
//        System.out.println(test1Service.getName());

        TestServiceInter testServiceInter = (TestServiceInter) ac.getBean("proxyFactoryBean");
        testServiceInter.sayHello();
        ((TestServiceInter2) testServiceInter).sayBye();
    }
}
