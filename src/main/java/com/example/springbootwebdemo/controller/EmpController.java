package com.example.springbootwebdemo.controller;

import com.example.springbootwebdemo.pojo.PageBean;
import com.example.springbootwebdemo.pojo.Result;
import com.example.springbootwebdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
