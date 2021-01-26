package com.pp.buying.controller;

import com.pp.buying.entity.Product;
import com.pp.buying.entity.ResultBody;
import com.pp.buying.exception.BizException;
import com.pp.buying.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    //测试全局异常处理
    //http://localhost:8080/getProduct?id=2
    @GetMapping("/getProduct")
    public ResultBody getProduct(Long id){
        Product product = productService.getProductById(id);
        if(product != null){
            return ResultBody.success(product);
        }
        return ResultBody.error("404","找不到该产品");
    }

    //测试自定义异常
    //http://localhost:8080/getBizException
    @GetMapping("/getBizException")
    public ResultBody getBizException(){
        if(true){
            throw new BizException("code","msg");
        }
        return ResultBody.success(null);
    }

    //测试空指针
    //http://localhost:8080/getNullPointerException
    @GetMapping("/getNullPointerException")
    public ResultBody getNullPointerException(){
        if(true){
            throw new NullPointerException();
        }
        return ResultBody.success(null);
    }

    //测试空指针
    //http://localhost:8080/getNullPointerException2
    @GetMapping("/getNullPointerException2")
    public ResultBody getNullPointerException2(){
        String str = null;
        str.equals("测试空指针");
        return ResultBody.success(null);
    }

    //测试其他异常
    //http://localhost:8080/getException
    @GetMapping("/getException")
    public ResultBody getException(){
        int i = 2/0;
        return ResultBody.success(null);
    }
}
