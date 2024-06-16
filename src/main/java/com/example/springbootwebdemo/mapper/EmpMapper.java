package com.example.springbootwebdemo.mapper;

import com.example.springbootwebdemo.pojo.Dept;
import com.example.springbootwebdemo.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //获取总记录数
    @Select("select count(*) from emp")
    public Long count();

    //获取当前页的结果列表
    @Select("select * from emp limit #{start}, #{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);


    //获取当前页的结果列表
    @Select("select * from emp")
    public List<Emp> page(Integer start, Integer pageSize);

//    @Select("select * from emp")
    public List<Emp> listNew(String name, Short gender, LocalDate begin, LocalDate end);

}
