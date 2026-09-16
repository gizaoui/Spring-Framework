package com.ex17.aspects;

import main.OutColor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    private static final Logger logger = LogManager.getLogger(SecurityAspect.class);

    @Pointcut("execution(public * com.ex17.service.ShoppingCategoryService.*(..))")
    public void checkSecurity() {
    }

    @Before("checkSecurity()")
    public void log(JoinPoint joinPoint) {
        logger.info(OutColor.GREEN.getCode() + "Appel de " +joinPoint.toShortString()+ " avec " +joinPoint.getArgs().length+ " paramètres" + OutColor.RESET.getCode());
    }

    @AfterThrowing(pointcut = "checkSecurity()", throwing = "e")
    public void log(JoinPoint joinPoint, Throwable e) {
        logger.info(OutColor.RED.getCode() + "Retour de "+joinPoint.toShortString()+" avec une exception " + e.getClass().getSimpleName() + OutColor.RESET.getCode());
    }

}
