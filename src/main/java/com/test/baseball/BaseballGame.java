package com.test.baseball;

import java.util.List;
import java.util.Random;

public class BaseballGame {
    public static void main(String[] args){
        new BaseballGame().run();
    }

    public void run(){

    }

    private List<Integer> createRandomNumbers(){
        NotDuplicateList numbers = new NotDuplicateList(BaseballConstant.NUMBER_COUNT);
        Random r = new Random();
        while(!numbers.isFull()) {
            int number = r.nextInt(9) + 1;
            numbers.add(number);
        }
        return numbers;
    }

}
