package com.example.demo.service;

import com.example.demo.dao.teaDao;
import com.example.demo.entity.TeaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class teaService {
    @Autowired
    private teaDao teaDao;

    public  int addTea(TeaInfo teaInfo){
        return teaDao.addTea(teaInfo);
    }

    public int updateTea(TeaInfo teaInfo){return teaDao.updateTea(teaInfo);}
    
}
