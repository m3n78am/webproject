package hello;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Jason on 4/8/17.
 */
public class App {

    public static void main(String[] args){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("hello-beans.xml");
        HelloWorld name = (HelloWorld) ac.getBean("helloBean");
        System.out.println(name.getName());

        DbUtil dbUtil = (DbUtil) ac.getBean("dbUtil");
        System.out.println("host: " + dbUtil.getHost());
    }
}
