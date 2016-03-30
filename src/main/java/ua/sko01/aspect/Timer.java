package ua.sko01.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import java.util.concurrent.TimeUnit;

@Aspect
public class Timer {
    @Pointcut("execution(* ua.sko01.tests.*.*Test.execute*(..))")
    public void testRun(){}

//    @Around("testRun()")
//    public Object measurePerformance(ProceedingJoinPoint joinpoint){
//        try{
//            joinpoint.proceed();
//           }catch (Throwable e){
//            System.err.println("Failed to run test");
//        }
//        return ("Failed to run the test");
//    }
}
