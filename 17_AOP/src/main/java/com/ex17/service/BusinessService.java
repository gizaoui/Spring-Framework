package com.ex17.service;

import com.ex17.aspects.SupervisionAspect;
import main.OutColor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    private static final Logger logger = LogManager.getLogger(SupervisionAspect.class);

    @Supervision(dureeMillis = 0)
    // @Supervision(dureeMillis = 10)
    public void doSomething() {
        logger.info(OutColor.YELLOW.getCode() + "Réalise un traitement important pour l'application (/!\\ modifier la durée 'dureeMillis')"+ OutColor.RESET.getCode());
    }

}