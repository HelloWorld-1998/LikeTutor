package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;

public class userService {
    @Autowired
    private userDao userDao;

    public int addUser(User user){
        return 0;
    }



}
