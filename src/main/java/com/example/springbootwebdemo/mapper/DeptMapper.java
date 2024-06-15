package com.example.springbootwebdemo.mapper;

import com.example.springbootwebdemo.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询所有的部门数据
     * @return   存储Dept对象的集合
     */
    //查询所有部门数据
    @Select("select id, name, create_time, update_time from dept")
    List<Dept> list();

    /**
     * 根据id删除部门信息
     * @param id   部门id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 添加部门信息
     * @param dept   部门对象
     */
    @Insert("insert into dept (name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
}
