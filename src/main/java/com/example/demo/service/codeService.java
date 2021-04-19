package com.example.demo.service;

import com.example.demo.dao.codeDao;
import com.example.demo.entity.UserCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class codeService {
    @Autowired
    private codeDao codeDao;

    public int addUserCode(UserCode userCode){
        return codeDao.addUserCode(userCode);
    }
}
