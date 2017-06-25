package com.primecoder.micro.transaction.aop.handler;

import com.primecoder.micro.transaction.util.threadlocal.MyThreadLocal;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * Created by primecoder on 2017/6/25.
 * E-mail : aprimecoder@gmail.com
 */
@Aspect
@Component
public class DistributeTransactionAnnotationHandler {


    @Around(value = "@annotation(com.primecoder.micro.transaction.aop.annotation.DistributeTransaction)")
    public Object handler(ProceedingJoinPoint proceeding) {

        System.out.println(MyThreadLocal.get());

        System.out.println("get the annotation!");

        Object o = null;

        try {

            o = proceeding.proceed(proceeding.getArgs());
        } catch (Throwable e) {
            e.printStackTrace();
        }

        System.out.println("end the annotation!");

        return o;
    }
}
