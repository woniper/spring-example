package net.woniper.spring.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class SimpleBeforeAspect {

    @Before("execution(* begin(..))")
    public void before(JoinPoint joinPoint) {
        log.info("--------------");
        log.info("before()");
        log.info("signature : " + joinPoint.getSignature());
    }
}