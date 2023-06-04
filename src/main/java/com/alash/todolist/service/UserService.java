package com.alash.todolist.service;

import com.alash.todolist.entity.User;

public interface UserService {

    User getUser(User user);

    boolean getUserByUsername(String username, String password);

    boolean findUserByUsername(String username);

    String saveUser(User user);
}
