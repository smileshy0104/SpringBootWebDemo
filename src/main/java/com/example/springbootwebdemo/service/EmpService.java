package com.example.springbootwebdemo.service;

import com.example.springbootwebdemo.pojo.Emp;
import com.example.springbootwebdemo.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 条件分页查询
     * @param page 页码
     * @param pageSize 每页展示记录数
     * @return
     */
    PageBean page(Integer page, Integer pageSize);

    /**
     * 分页查询(使用内置的PageHelper)
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除操作
     * @param ids id集合
     */
    void deleteEmpByID(List<Integer> ids);


    /**
     * 保存员工信息
     * @param emp
     */
    void save(Emp emp);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    public Emp getById(Integer id);


    //修改员工信息
    public void update(Emp emp);


    /**
     * 用户登录
     * @param emp
     * @return
     */
    public Emp login(Emp emp);
}
