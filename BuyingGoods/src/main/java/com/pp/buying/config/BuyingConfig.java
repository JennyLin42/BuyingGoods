package com.pp.buying.config;

import com.pp.buying.intercepter.LoginIntercepter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类
 */

@Configuration
public class BuyingConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(new LoginIntercepter());
        // 配置拦截的路径 拦截所有请求
        ir.addPathPatterns("/**");
        // 配置不拦截的路径
        //ir.excludePathPatterns("/user/info", "/user/add");
        // 还可以在这里注册其它的拦截器
        //registry.addInterceptor(new OtherInterceptor()).addPathPatterns("/**");
    }

}
