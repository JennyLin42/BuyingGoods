package com.pp.buying.controller;

import com.pp.buying.entity.Result;
import com.pp.buying.service.PurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseRecordService purchaseRecordService;

    //http://localhost:8080/test
    @RequestMapping("/test")
    public ModelAndView testPage(){
        ModelAndView mv = new ModelAndView("test");
        return mv;
    }

    @RequestMapping("/purchase")
    public Result purchase(Long userId,Long productId,Integer quantity){
        boolean success = purchaseRecordService.purchse(userId,productId,quantity);
        String message = success ? "抢购成功" : "抢购失败";
        Result result = new Result(success,message);
        return result;
    }

}
