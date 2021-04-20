package com.example.demo.dao;

import com.example.demo.entity.StuInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface stuDao {
    String table_name="stu_info";
    String insert_field="user_pid,username,wxnumber,usersex,grade1st,situation," +
            "school,address,weektime,daytime,attime,asksex,asktype,askfor";

    @Insert({"insert into",table_name, "(", insert_field,
            ") values (#{userPid},#{username},#{wxnumber},#{usersex},#{grade}," +
                    "#{situation},#{school},#{address},#{weektime},#{daytime},#{attime},#{asksex},#{asktype},#{askfor}"})
    int addStu(StuInfo stuInfo);

    @Select({"select * from ",table_name,"where user_pid=#{userPid}"})
    List<StuInfo> selectUser(int userPid);

    @Select({"select * from ",table_name})
    List<StuInfo> selectAll();

//    @Update({"update ", table_name, " set status=#{status} where user_id=#{id}"})
//    void updateBookStatus(@Param("id") int id, @Param("status") int status);

    @Delete({"delete from",table_name,"where orderid=#{orderid}"})
    void delStu(int orderid);
}
