package com.ex04.service;

import com.ex04.entity.College;
import org.springframework.stereotype.Component;

@Component
public class CollegeService {

    public String getMessage(College college) {
        return college.toString();
    }
}
