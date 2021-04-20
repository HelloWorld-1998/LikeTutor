package com.example.demo.dao;

import com.example.demo.entity.UserCode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface codeDao {
    String table_name="user_code";
    String insert_field="user_openid,user_sessionkey";//user_pid,user_openid,user_sessionkey

    @Insert({"insert into",table_name, "(", insert_field,
            ") values (#{userOpenid},#{userSessionkey})"})
    int addUserCode(UserCode userCode);

    @Select({"select user_pid from user_code where user_openid=#{openid}"})
    Integer selectUserPid(String openid);
}
