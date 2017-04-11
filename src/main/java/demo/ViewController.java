package demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jason on 4/10/17.
 */

@Controller
@RequestMapping("/view")
public class ViewController {

        @RequestMapping(method = RequestMethod.GET)
        public String index(ModelMap model) {
            model.addAttribute("message", "Hello, Spring MVC资源绑定视图解析器!");
            return "view";
        }
}
