package com.example.demo.dao;


import com.example.demo.entity.TeaInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface teaDao {
    String table_name="tea_info";
    String insert_field="user_pid,tphoto,tname,tsex,tnumber,tschool," +
            "tmajor,ttype,thomme,tgrade,treward,tinfo,texp";

    @Insert({"insert into",table_name, "(", insert_field,
            ") values (#{userPid},#{tphoto},#{tname},#{tsex},#{tnumber},#{tschool},",
            "#{tmajor},#{ttype},#{thomme},#{tgrade},#{treward},#{tinfo},#{texp})"})
    int addTea(TeaInfo teaInfo);

    List<TeaInfo> selectTea(int teaInfo);

    List<TeaInfo> selectAll();
}
