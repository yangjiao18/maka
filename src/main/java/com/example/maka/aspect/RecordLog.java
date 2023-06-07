package com.example.maka.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RecordLog {

    @Pointcut("execution(* com.example.maka.controller..*.*(..))")
    public void pointcut(){}
}
