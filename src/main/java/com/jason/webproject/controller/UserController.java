package com.jason.webproject.controller;

import com.jason.webproject.dto.UserDto;
import com.jason.webproject.service.UserService;
import com.jason.webproject.util.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 4/11/17.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(@RequestParam Map<String, String> queryMap, Model model) {
        return "forword:/show";
    }

    @RequestMapping(value = "userList",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<List<UserDto>> getListJson(@RequestParam Map<String, String> queryMap) {

        int pageNo = Integer.parseInt(queryMap.containsKey("page") ? queryMap.get("page") : "1");
        int pageSize = Integer.parseInt(queryMap.containsKey("size") ? queryMap.get("size") : "10");
        List<UserDto> result = getListByPageno(pageNo, pageSize);
        return new JsonResult<List<UserDto>>(result);
    }

    @RequestMapping(value = "userInfo",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<UserDto> getUserInfoJson(@RequestParam Map<String, String> queryMap) {
        int userId= Integer.parseInt(queryMap.containsKey("userId") ? queryMap.get("userId") : "1");
        UserDto result = userService.getUserById(userId);
        return new JsonResult<UserDto>(result);
    }



    @RequestMapping(value = "show",method = RequestMethod.GET)
    public String getListView(@RequestParam Map<String, String> queryMap, Model model) {

        int pageNo = Integer.parseInt(queryMap.containsKey("page") ? queryMap.get("page") : "1");
        int pageSize = Integer.parseInt(queryMap.containsKey("size") ? queryMap.get("size") : "10");
        List<UserDto> userList = getListByPageno(pageNo, pageSize);
        model.addAttribute("userList", userList);
        return "listUser";
    }


    public List<UserDto> getListByPageno(int pageNo, int pageSize){
        int startId = (pageNo -1) * pageSize;
        List<UserDto> result = userService.getUserByPageno(startId, pageSize);
        return result;
    }


    @RequestMapping(value = "addUser",method = RequestMethod.GET)
    public ModelAndView getAddUserView(@RequestParam Map<String, String> queryMap, ModelAndView modelAndView) {
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @RequestMapping(value = "active",method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView active(@RequestParam Map<String, String> queryMap, ModelAndView modelAndView) {
        String action = queryMap.getOrDefault("action","list");
        if (action.equals("add")){
           String name = queryMap.get("name");
           int age = Integer.parseInt(queryMap.get("age"));

            String sex = queryMap.get("sex");
            String contact = queryMap.get("contact");

            int gender = 0;
            if (sex.equals("M")) {
                gender = 1;
            }else if (sex.equals("F")){
                gender = 2;
            }
            userService.addUser(name,age,gender,contact);

        }else if(action.equals("remove")){
            int id = Integer.parseInt(queryMap.get("userId"));
            userService.deleteUserById(id);
        }else if (action.equals("search")){
            String name = queryMap.get("userName");
            List<UserDto> result = userService.getUserByNameLike(name);
            modelAndView.addObject("userList",result);
            modelAndView.setViewName("listUser");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/user/show");
        // return "redirect:/user/show";
        return modelAndView;
    }

}
