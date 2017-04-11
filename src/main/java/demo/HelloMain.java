package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Jason on 4/8/17.
 */
public class HelloMain {


    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        HelloWorldService service =
                (HelloWorldService) context.getBean("helloWorldService");

        HelloWorld hw = service.getHelloWorld();

        hw.sayHello();
    }
}