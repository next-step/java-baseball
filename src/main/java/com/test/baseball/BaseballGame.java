package com.test.baseball;

import java.util.List;
import java.util.Random;

public class BaseballGame {
    private final int NUMBER_COUNT = 3;

    public static void main(String[] args){
        new BaseballGame().run();
    }

    public void run(){

    }

    private List<Integer> createRandomNumbers(){
        List<Integer> numbers = new NotDuplicateList();
        Random r = new Random();
        while(numbers.size() < NUMBER_COUNT) {
            int number = r.nextInt(9) + 1;
            numbers.add(number);
        }
        return numbers;
    }

}
