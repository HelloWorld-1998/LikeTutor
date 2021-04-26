package com.example.demo.dao;


import com.example.demo.entity.TeaInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface teaDao {
    String table_name="tea_info";
    String insert_field="user_pid,tphoto,tname,tsex,tnumber,tschool," +
            "tmajor,ttype,thome,tgrade,treward,tinfo,texp";

    @Insert({"insert into",table_name, "(", insert_field,
            ") values (#{userPid},#{tphoto},#{tname},#{tsex},#{tnumber},#{tschool},",
            "#{tmajor},#{ttype},#{thome},#{tgrade},#{treward},#{tinfo},#{texp})"})
    int addTea(TeaInfo teaInfo);

    @Update({"update ",table_name,"set tphoto=#{tphoto} where user_pid=#{user_pid}"})
    int updateTea(TeaInfo teaInfo);

    List<TeaInfo> selectTea(int teaInfo);

    List<TeaInfo> selectAll();
}
