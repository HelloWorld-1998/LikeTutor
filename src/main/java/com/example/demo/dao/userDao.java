package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface userDao {
    String table_name="user";
    String insert_field="UserId,UserName,Age";

    @Insert({"insert into",table_name, "(", insert_field,
            ") values (#{userOpenid},#{userSessionkey)"})
    int addUser(User user);

    @Select({"select UserName from user where Age=#{age}"})
    String selectUser(String age);
}
