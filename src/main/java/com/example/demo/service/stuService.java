package com.example.demo.service;

import com.example.demo.dao.stuDao;
import com.example.demo.entity.StuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class stuService {
    @Autowired
    private stuDao stuDao;

    public int addStu(StuInfo stuInfo){
        return stuDao.addStu(stuInfo);
    }
    public List<StuInfo> selectUser(int userpid){
        return stuDao.selectUser(userpid);
    }
    public List<StuInfo> selectAll(){
        return stuDao.selectAll();
    }
    public void delStu(int orderid){
        stuDao.delStu(orderid);
    }
}
