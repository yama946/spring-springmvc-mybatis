package com.yama.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 * 注意：如果使用注解进行配置切面时，如果不使用环绕通知配置通知方法，会出现问题
 *      使用环绕通知实现事务是编程式事务控制，因为可以手动控制事务执行，
 *      当时不使用环绕通知配置，是使用纯aop配置的方法来实现事务的控制
 *
 *
 * 当在使用注解配置时，仅配置前置通知，后置通知、异常通知、最终通知，这是，通知方法执行的顺序会出现异常，
*    此时最终通知方法，始终会先于后置通知和异常通知执行。
 */
@Component("logger")
@Aspect//表示当前类是一个切面类，相当于<aop:aspect id="logAdvice" ref="logger"></aop:aspect>标识此类为通知类，切面的一部分
public class Logger {

    @Pointcut("execution(* com.yama.service.impl.*.*(..))")//配置切入点表达式，
    //相当于<aop:pointcut id="pt1" expression="execution(* com.yama.service.impl.*.*(..))"></aop:pointcut>
    private void pt1(){}

    /**
     * 前置通知
     */
//    @Before("pt1()") //相当于--<aop:before method="beforePrintLog" pointcut-ref="pt1" ></aop:before>
    public  void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
//    @AfterReturning("pt1()")
    public  void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }
    /**
     * 异常通知
     */
//    @AfterThrowing("pt1()")
    public  void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
//    @After("pt1()")
    public  void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }

    /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
     * 解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     *
     * spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    @Around("pt1()")//此时的切入点表达式的名字中括号是必须的
    public Object aroundPringLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。前置");

            rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）

            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。后置");

            return rtValue;
        }catch (Throwable t){
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。异常");
            throw new RuntimeException(t);
        }finally {
            System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。最终");
        }
    }
}
