package com.pp.buying.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * 日志切面
 */
@Aspect
@Component
public class LogAspect {

    private static final String LOG_FORMATTER = "%s.%s - %s";
    private Logger log = LogManager.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.pp.buying.controller.*.*(..)) && @annotation(com.pp.buying.annotation.MyAnnotation)")
    public void annotationPointcut(){

    }

    //目标方法前执行
    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint){
        log.info("beforePointcut...");
//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object [] args = joinPoint.getArgs();
//        String params = "";
//        for (int i = 0; i < args.length; i++) {
//            params = params + ("第" + (i+1) + "个参数为:" + args[i]);
//        }
//        log.info(String.format(LOG_FORMATTER,className,methodName,params.toString()));
    }

    //可以自定义目标方法执行的时机
    //ProceedingJoinPoint是JoinPoint的子类，只能用在arount上
    //此方法需要返回值,返回值视为目标方法的返回值
    @Around("annotationPointcut()")
    public Object aroundPointcut(ProceedingJoinPoint pjp){
        Object result = null;
        try {
            log.info("aroundPointcut目标方法执行前...");
            Object [] args = pjp.getArgs();
            if(args.length > 0){
                Object[] args1 = pjp.getArgs();
                args1[0] = "10000";
                //用新的参数执行目标方法
                result = pjp.proceed(args);
            } else{
                //执行目标方法
                result = pjp.proceed();
            }


            log.info("aroundPointcut目标方法执行后...");

        } catch (Throwable e){
            log.info("aroundPointcut目标方法执行异常...");
            throw new RuntimeException(e);
        }
        return result;
    }

    //目标方法后执行
    @After("annotationPointcut()")
    public void afterPointcut(JoinPoint joinPoint){
        log.info("afterPointcut...");

//        String className = joinPoint.getTarget().getClass().getName();
//        String methodName = joinPoint.getSignature().getName();
//        Object [] args = joinPoint.getArgs();
//        String params = "";
//        for (int i = 0; i < args.length; i++) {
//            params = params + ("第" + (i+1) + "个参数为:" + args[i]);
//        }
//        log.info(String.format(LOG_FORMATTER,className,methodName,params.toString()));
    }
}
