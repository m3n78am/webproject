package com.jason.webproject;

import com.jason.webproject.inter.IUserOperation;
import com.jason.webproject.model.User;
import demo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jason on 4/11/17.
 */

@Controller
@RequestMapping("/hello")
public class UserController {

    @Autowired
    IUserOperation userMapper;

    @RequestMapping(value = "print",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<User> json() {
        User result = userMapper.selectUserByID(1);
        return new JsonResult<>(result);
    }

}
