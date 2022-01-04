package com.lf2a.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DataBaseFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "";
    }
}
