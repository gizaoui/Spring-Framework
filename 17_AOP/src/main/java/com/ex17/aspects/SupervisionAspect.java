package com.ex17.aspects;

import com.ex17.service.Supervision;
import main.Main;
import main.OutColor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class SupervisionAspect {

    private static final Logger logger = LogManager.getLogger(SupervisionAspect.class);

    @Around("@annotation(supervision)")
    public Object superviser(ProceedingJoinPoint joinPoint, Supervision supervision) throws Throwable {

        long maxDuree = supervision.dureeMillis();
        long start = System.currentTimeMillis();

        try {
            return joinPoint.proceed(joinPoint.getArgs());
        } finally {
            long end = System.currentTimeMillis();
            long duree = end - start;
            if (duree > maxDuree) {
                logger.info(OutColor.YELLOW.getCode() + "Attention l'appel à "+joinPoint.toShortString()+" à durée " +duree+ "ms soit "+(duree - maxDuree)+"ms de plus qu'attendu"+ OutColor.RESET.getCode());
            }
        }
    }

}