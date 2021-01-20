package com.pp.buying.controller;

import com.pp.buying.entity.Product;
import com.pp.buying.entity.ResultBody;
import com.pp.buying.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    //http://localhost:8080/getProduct?id=2
    @GetMapping("/getProduct")
    public ResultBody getProduct(Long id){
        Product product = productService.getProductById(id);
        if(product != null){
            return ResultBody.success(product);
        }
        return ResultBody.error("404","找不到该产品");
    }

    //http://localhost:8080/getProduct1/2
    @GetMapping("/getProduct1/{id}")
    public ResultBody getProduct1(@PathVariable("id") Long id){
        Product product = productService.getProductById(id);
        if(product != null){
            return ResultBody.success(product);
        }
        return ResultBody.error("404","找不到该产品");
    }


}
