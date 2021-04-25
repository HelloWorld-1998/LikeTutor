package com.example.demo.dao;

import com.example.demo.entity.UserCode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface codeDao {
    String table_name="user_code";
    String insert_field="user_openid,user_sessionkey,lasttime";//user_pid,user_openid,user_sessionkey

    @Insert({"insert into",table_name, "(", insert_field,
            ") values (#{userOpenid},#{userSessionkey},#{lasttime})"})
    int addUserCode(UserCode userCode);

    @Update({"update",table_name, "set lasttime = #{lasttime} , user_sessionkey =#{userSessionkey}  where user_openid = #{userOpenid}"})
    int updateUserCode(UserCode userCode);

    @Select({"select user_pid from user_code where user_openid=#{openid}"})
    Integer selectUserPid(String openid);
}
