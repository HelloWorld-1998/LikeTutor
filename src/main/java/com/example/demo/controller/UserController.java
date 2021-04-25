package com.example.demo.controller;

import com.example.demo.entity.StuInfo;
import com.example.demo.entity.TeaInfo;
import com.example.demo.entity.UserCode;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.*;

import com.example.demo.service.stuService;
import com.example.demo.service.codeService;
import com.example.demo.utils.HttpUtil;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.OpenIdJson;


import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private codeService codeService;

    @Autowired
    private stuService stuService;

    @RequestMapping(value = "/abc",method = RequestMethod.GET)
    @ResponseBody
    public String getUsers(@RequestParam String age){//@RequestParam int age
        String sql="select UserName from User where Age="+age;//SQL查询语句
        String list=jdbcTemplate.queryForObject(sql,String.class);

        //List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);

        //String sql="INSERT INTO user VALUES('0018','宋斌斌',28)";
        //jdbcTemplate.update(sql);
        return list;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public String addUsers(@RequestParam String age){//@RequestParam int age
        String sql="INSERT INTO user VALUES ('0020','SYY','"+age+"')";//SQL查询语句
        jdbcTemplate.update(sql);

        return "OK";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String testdemo(@RequestParam String acc,@RequestParam String ass){//@RequestParam int age
        if(acc.equals("123"))
            return "OKA";
        else
            System.out.println(acc+":"+ass);
            return "NO";
    }

    @RequestMapping(value = "/openid",method = RequestMethod.GET)
    @ResponseBody
    public int getOpenID(@RequestParam String data) throws IOException {//@RequestParam int age
        System.out.println(data);
        String appID = "wxc3ff00992ce9b322";
        String appSecret = "f0f4d54f69c6b95fec59c229807ecc83";

        String result = "";
        try{//请求微信服务器，用code换取openid。
            result = HttpUtil.doGet(
                    "https://api.weixin.qq.com/sns/jscode2session?appid="
                            + appID + "&secret="
                            + appSecret + "&js_code="
                            + data
                            + "&grant_type=authorization_code", null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        UserCode userCode=new UserCode();//实体类

        OpenIdJson openIdJson = mapper.readValue(result,OpenIdJson.class);//我构建的实例

        //lasttime
        java.sql.Date nowSql = new java.sql.Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //System.out.println(nowSql);//format.format(nowSql)
        userCode.setLasttime(nowSql);
        userCode.setUserOpenid(openIdJson.getOpenid());
        userCode.setUserSessionkey(openIdJson.getSession_key());


        if(codeService.selectUserPid(userCode)==null){
            System.out.println("加一个");
            codeService.addUserCode(userCode);
            System.out.println("添加成功");
        }
        else {
            System.out.println("更新时间");
            codeService.updateUserCode(userCode);
            System.out.println("更新成功");
        }
        System.out.println(codeService.selectUserPid(userCode));
        System.out.println(result.toString());
        System.out.println(openIdJson.getOpenid());

//        userCode.setUserOpenid(openIdJson.getOpenid());   //openid
//        userCode.setUserSessionkey(openIdJson.getSession_key());  //seesion key

//        codeService.addUserCode(userCode);


        return codeService.selectUserPid(userCode);
    }

    @RequestMapping(value = "/addstuinfo",method = RequestMethod.GET)
    @ResponseBody
    public String addStuInfo(@RequestParam String stuInfobuff){//StuInfo stuInfo Map<String,Object>
        System.out.println(stuInfobuff);
        JSONObject jsonObject=JSON.parseObject(stuInfobuff);
        StuInfo stuInfo=new StuInfo();
        System.out.println(jsonObject.get("user_pid"));
        //set
        stuInfo.setUserPid(Integer.parseInt(jsonObject.get("user_pid").toString()));
        stuInfo.setUsername(jsonObject.get("username").toString());
        stuInfo.setWxnumber(jsonObject.get("wxnumber").toString());
        stuInfo.setUsersex(jsonObject.get("usersex").toString());
        stuInfo.setGrade(jsonObject.get("grade").toString());
        stuInfo.setSituation(jsonObject.get("situation").toString());
        stuInfo.setSchool(jsonObject.get("school").toString());
        stuInfo.setAddress(jsonObject.get("address").toString());
        stuInfo.setWeektime(jsonObject.get("weektime").toString());
        stuInfo.setDaytime(jsonObject.get("daytime").toString());
        stuInfo.setAttime(jsonObject.get("attime").toString());
        stuInfo.setAsksex(jsonObject.get("asksex").toString());
        stuInfo.setAsktype(jsonObject.get("asktype").toString());
        stuInfo.setAskfor(jsonObject.get("askfor").toString());

        System.out.println(stuInfo.toString());
        //写入数据库 学生信息
        //stuService.addStu(stuInfo);
        return "OK";
    }


    @RequestMapping(value = "/addteainfo",method = RequestMethod.GET)
    @ResponseBody
    public String postman(@RequestParam String teaInfobuff){
        System.out.println(teaInfobuff.toString());
        return "ok";
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(HttpServletRequest request,@RequestParam MultipartFile file){
        System.out.println(file.toString());
        return "ok";
    }


//    @RequestMapping(value = "/posttest",method = RequestMethod.GET)
//    @ResponseBody
//    public String postman(@RequestBody StuInfo stuInfobuff){//StuInfo stuInfo Map<String,Object>
//        System.out.println(stuInfobuff.toString());
//        return "ok";
//    }
}
