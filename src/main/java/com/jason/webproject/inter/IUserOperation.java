package com.jason.webproject.inter;

import com.jason.webproject.model.User;

/**
 * Created by Jason on 4/11/17.
 */
public interface IUserOperation {
    public User selectUserByID(int id);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
}
