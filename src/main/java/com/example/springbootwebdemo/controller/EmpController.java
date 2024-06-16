package com.example.springbootwebdemo.controller;

import com.example.springbootwebdemo.pojo.PageBean;
import com.example.springbootwebdemo.pojo.Result;
import com.example.springbootwebdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//员工管理控制器
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    //条件分页查询
    @GetMapping("/emp")
    // 参数：page：当前页码，pageSize：每页显示条数(默认值1/10)
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        //记录日志
//        log.info("分页查询，参数：{},{}", page, pageSize);
        //调用业务层分页查询功能
        PageBean pageBean = empService.page(page, pageSize);
        //响应
        return Result.success(pageBean);
    }

    @GetMapping("/emp_new")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
//        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        //调用service分页查询
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    //批量删除
    @DeleteMapping("/emp/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        empService.deleteEmpByID(ids);
        return Result.success();
    }
}
