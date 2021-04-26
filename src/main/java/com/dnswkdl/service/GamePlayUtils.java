package com.dnswkdl.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamePlayUtils {

    public static List<Integer> toList(int number){
        List<Integer> result = new ArrayList<>();
        int first = number/100;
        int second = (number - first*100)/10;
        int third = (number - first*100)%10;
        result.add(first);
        result.add(second);
        result.add(third);
        return result;
    }
}
