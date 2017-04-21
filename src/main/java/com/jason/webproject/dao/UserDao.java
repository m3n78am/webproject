package com.jason.webproject.dao;

import com.jason.webproject.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Jason on 4/11/17.
 */
public interface UserDao {
    public User selectUserByID(int id);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUserById(int id);
    public List<User> selectUsersByPageno(@Param("startId") int startId, @Param("pageSize") int pageSize);
    public List<User> selectUserByNameLike(@Param("name") String name);
}
