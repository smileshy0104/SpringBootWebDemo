package com.example.springbootwebdemo.controller;

import com.example.springbootwebdemo.pojo.Result;
import com.example.springbootwebdemo.utils.AliOSSUtils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    // 表单项的名字和方法中形参名一致时（上传到本地）
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        //获取原始文件名
        String originalFilename = image.getOriginalFilename();

        //构建新的文件名
        String extname = originalFilename.substring(originalFilename.lastIndexOf("."));//文件扩展名
        String newFileName = UUID.randomUUID().toString()+extname;//随机名+文件扩展名

        //将文件存储在服务器的磁盘目录
        image.transferTo(new File("E:/images/"+newFileName));

        return Result.success();
    }
    // 表单项的名字和方法中形参名不一致时，需要使用@RequestParam（上传到本地）
    public Result uploadNew(String username,Integer age,@RequestParam("image") MultipartFile file){

        return Result.success();
    }

    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload_oss")
    public Result uploadOss(MultipartFile image) throws IOException {
        //调用阿里云OSS工具类，将上传上来的文件存入阿里云
        String url = aliOSSUtils.upload(image);
        //将图片上传完成后的url返回，用于浏览器回显展示
        return Result.success(url);
    }
}