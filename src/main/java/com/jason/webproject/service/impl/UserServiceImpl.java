package com.jason.webproject.service.impl;

import com.jason.webproject.dao.UserDao;
import com.jason.webproject.dto.UserDto;
import com.jason.webproject.model.User;
import com.jason.webproject.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 4/14/17.
 */
@Component
public class UserServiceImpl implements UserService{

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final Map<Integer, String> genderMap = new HashMap<Integer, String>() {{
        put(0, "unkown");
        put(1, "male");
        put(2, "female");
    }};

    @Autowired
    UserDao userMapper;

    public UserDto getUserById(int id) {
        User user = userMapper.selectUserByID(id);
        UserDto result = new UserDto();
        result.setId(user.getId());
        result.setName(user.getName());
        result.setAge(user.getAge());
        result.setContact(user.getContact());
        result.setSex(genderMap.get(user.getGender()));
       return result;
    }

    @Override
    public List<UserDto> getUserByPageno(int startId, int pageSize) {

        List<User> userList = userMapper.selectUsersByPageno(startId,pageSize);
        List<UserDto> result = transfer(userList);
        return result;
    }

    @Override
    public void addUser(String name, int age, int gender, String contact) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        user.setContact(contact);
        userMapper.addUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public List<UserDto> getUserByNameLike(String name) {
        return transfer(userMapper.selectUserByNameLike(name));
    }

    public List<UserDto> transfer(List<User> userList){
        List<UserDto> result = new ArrayList<>();
        for (User user:userList) {
            UserDto x = new UserDto();
            x.setId(user.getId());
            x.setName(user.getName());
            x.setAge(user.getAge());
            x.setContact(user.getContact());
            x.setSex(genderMap.get(user.getGender()));
            result.add(x);
        }
        return result;
    }

}
