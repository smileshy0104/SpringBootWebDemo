package com.example.springbootwebdemo.mapper;

import com.example.springbootwebdemo.pojo.Dept;
import com.example.springbootwebdemo.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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


    //通过id删除Emp
    void deleteEmpByID(List<Integer> ids);

    //新增员工
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime});")
    void insert(Emp emp);


    //根据ID查询员工信息
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
            "from emp " +
            "where id = #{id}")
    public Emp findById(Integer id);


    //修改员工信息
    public void update(Emp emp);
}
