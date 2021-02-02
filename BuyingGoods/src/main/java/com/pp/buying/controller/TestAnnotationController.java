package com.pp.buying.controller;

import com.pp.buying.annotation.MyAnnotation;
import com.pp.buying.vo.ResultBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试自定义注解
 */

@RestController
@RequestMapping("/testAnnotation")
public class TestAnnotationController {

    @MyAnnotation
    //http://localhost:8080/testAnnotation/noAttribute
    @RequestMapping("/noAttribute")
    public ResultBody testNoAttribute(){
        return ResultBody.success(null);
    }

    @MyAnnotation
    //http://localhost:8080/testAnnotation/hasAttribute/msg
    @RequestMapping("/hasAttribute/{msg}")
    public ResultBody testhasAttribute(@PathVariable("msg") String msg){
        return ResultBody.success(msg);
    }

    @MyAnnotation
    //http://localhost:8080/testAnnotation/hasAttribute2?msg=11111
    @RequestMapping("/hasAttribute2")
    public ResultBody testhasAttribute2( String msg){
        return ResultBody.success(msg);
    }
}
