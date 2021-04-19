package com.example.demo.controller;

import com.example.demo.entity.UserCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.codeService;
import com.example.demo.utils.HttpUtil;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.entity.OpenIdJson;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private codeService codeService;

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
    public String getOpenID(@RequestParam String data) throws IOException {//@RequestParam int age
        System.out.println(data);
        String appID = "wxc3ff00992ce9b322";
        String appSecret = "f0f4d54f69c6b95fec59c229807ecc83";

        UserCode userCode=new UserCode();//实体类
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
        OpenIdJson openIdJson = mapper.readValue(result,OpenIdJson.class);

        userCode.setUserOpenid(openIdJson.getOpenid());
        userCode.setUserSessionkey(openIdJson.getSession_key());
        codeService.addUserCode(userCode);

        System.out.println(result.toString());
        System.out.println(openIdJson.getOpenid());
        return result;
    }
}
