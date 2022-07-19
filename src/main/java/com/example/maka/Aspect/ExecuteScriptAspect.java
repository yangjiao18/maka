package com.example.maka.Aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecuteScriptAspect {

    @Pointcut("@annotation(com.example.maka.Commen.Recording)")
    public void executeScript() {

    }

    //前置通知
    @Before("executeScript()")
    public void startRecording() {
        System.out.println("方法开始-前置通知");
    }

    /**
     * 脚本执行后结束录屏
     */
    @After("executeScript()")
    public void endRecording() {
        System.out.println("方法结束-后置通知");
    }

    // //returning能够将目标方法的返回值传到切面增强方法里
    //    // 声明rvt时指定的类型会限制目标方法必须返回指定类型(String)的值或没有返回值
    //    // 此处将rvt的类型声明为Object，意味着对目标方法的返回值不加限制
    @AfterReturning(pointcut = "executeScript()", returning = "rvt")
    public void logTestAfterReturing4(String rvt) {
        System.out.println("测试AfterReturning---returning:" + rvt);
    }

    @AfterReturning(value = "executeScript()&& args(a,b)", argNames = "a,b")
    public void logTestAfterReturning4(String a, String b) {
        System.out.println("使用arg,能够将目标方法的参数传到切面增强方法里:a=" + a + ";b=" + b);
    }

    @AfterReturning(value = "executeScript()&& args(a,b)", argNames = "b,a")
    public void logTestAfterReturning5(String b, String a) {
        System.out.println("使用argNames,能够调整参数顺序，默认值为arg中顺序:b=" + b + ";a=" + a);
    }


}



