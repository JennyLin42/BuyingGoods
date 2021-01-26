package com.pp.buying.controller;

import com.pp.buying.entity.ResultBody;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class UploadController {

    //http://localhost:8080/goUploadAndDownload
    @RequestMapping("/goUploadAndDownload")
    public String goUploadAndDownload(){
        return "uploadAndDownload";
    }

    //上传文件
    @RequestMapping("/upload")
    @ResponseBody
    public ResultBody upload(@RequestParam("filename") MultipartFile multipartFile) throws IOException {
        System.out.println("文件名："+multipartFile.getOriginalFilename());
        //保存文件
        multipartFile.transferTo(new File("e:/"+multipartFile.getOriginalFilename()));
        return ResultBody.success("文件上传成功");
    }

    @RequestMapping("/download")
    public ResponseEntity<Object> download() throws IOException{
        //String fileName = "E:/springmvcfile/1.jpg";
        String fileName = "E:/1.jpg";
        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream((file)));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",String.format("attachment;filename=\"%s\"",file.getName()));
        headers.add("Cache-Control","no-cache,no-store,must-revalidate");
        headers.add("Pragma","no-cache");
        headers.add("Expires","0");

        ResponseEntity<Object> responseEntity = ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/text"))
                .body(resource);
        return responseEntity;    }
}
