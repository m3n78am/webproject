package com.jason.webproject.service;

import com.jason.webproject.dto.UserDto;

import java.util.List;

/**
 * Created by Jason on 4/14/17.
 */
public interface UserService {
    public UserDto getUserById(int id);
    public List<UserDto> getUserByPageno(int startId, int pageSize);
    public void addUser(String name, int age,int gender,String contact);
    public void deleteUserById(int id);
    public List<UserDto> getUserByNameLike(String name);
}
