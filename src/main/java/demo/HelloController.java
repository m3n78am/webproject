package demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jason on 4/8/17.
 */

@Controller
@RequestMapping("/hello")
public class HelloController{

    @RequestMapping(value = "print",method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        // model.addAttribute("message", "Hello Spring MVC Framework!");
        System.out.println("model = [" + model + "]");
        return "hello";
    }

    @RequestMapping("json")
    @ResponseBody
    public JsonResult<Greeting> json() {
        Greeting result = new Greeting();
        result.setContent("hello");
        result.setId (1l);
        return new JsonResult<>(result);
    }

}