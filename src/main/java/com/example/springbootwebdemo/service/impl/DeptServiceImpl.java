package com.example.springbootwebdemo.service.impl;

import com.example.springbootwebdemo.mapper.DeptMapper;
import com.example.springbootwebdemo.pojo.Dept;
import com.example.springbootwebdemo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

//员工业务实现类
@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    // 注入部门mapper
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        List<Dept> deptList = deptMapper.list();
        return deptList;
    }

    @Override
    public void delete(Integer id) {
        //调用持久层删除功能
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        //补全部门数据
//        dept.setName("测试部");
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //调用持久层增加功能
        deptMapper.insert(dept);
    }
}
