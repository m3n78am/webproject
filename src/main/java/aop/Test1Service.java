package aop;

/**
 * Created by Jason on 4/9/17.
 */
public class Test1Service implements TestServiceInter,TestServiceInter2 {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("Test1Service's sayHello");
    }

    @Override
    public void sayBye() {
        System.out.println("Test1Service's sayBye");
    }
}
