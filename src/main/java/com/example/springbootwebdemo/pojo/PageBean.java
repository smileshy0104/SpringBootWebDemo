package com.example.springbootwebdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 分页查询需要的数据，封装在PageBean对象中
public class PageBean {
    private Long total; //总记录数
    private List rows; //当前页数据列表
}
