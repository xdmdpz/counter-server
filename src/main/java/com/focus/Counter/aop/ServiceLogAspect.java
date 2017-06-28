//package com.focus.Counter.aop;
//import org.apache.commons.lang3.ArrayUtils;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.CodeSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//@Aspect
//@Component
///**
// * Created by if on 2017/6/28.
// */
//public class ServiceLogAspect {
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Pointcut("execution(public * com.focus.Counter.service.*.*(..))")
//    public void service() {
//    }
//
//    @Before("service()")
//    public void writeBeforeLog(JoinPoint jp) {
//        this.debugInController(jp, "Start");
//    }
//
//    @After("service()")
//    public void writeAfterLog(JoinPoint jp) {
//        this.debugInController(jp, "End");
//    }
//
//    private void debugInController(JoinPoint jp, String msg) {
//        this.logger.debug("\n{}.{}() {} ", jp.getTarget().getClass().getSimpleName(), jp.getSignature().getName(), msg);
//    }
//
//
//    @Before("service()")
//    public void writeParams(JoinPoint jp) {
//        String[] names = ((CodeSignature) jp.getSignature())
//                .getParameterNames();
//        Object[] args = jp.getArgs();
//
//        if (ArrayUtils.isEmpty(names)) {
//            return;
//        }
//
//        StringBuilder sb = new StringBuilder("Arguments: ");
//        for (int i = 0; i < names.length; i++) {
//            sb.append(names[i] + " = " + args[i] + ",");
//        }
//
//        debugInController(jp, sb.toString());
//    }
//}
