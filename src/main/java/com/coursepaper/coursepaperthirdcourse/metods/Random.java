package com.coursepaper.coursepaperthirdcourse.metods;

import org.springframework.stereotype.Component;

@Component
public class Random {

    public int nextInt(int maxNumber) {
        return ((int) (Math.random() * maxNumber));
    }

}
