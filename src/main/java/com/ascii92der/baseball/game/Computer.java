package com.ascii92der.baseball.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
    private List<Integer> numberList;

    public Computer(){
        numberList = generateNumbers();
    }

    public List<Integer> generateNumbers() {
        Random random = new Random();
        List<Integer> returnNumberList = new ArrayList<Integer>();
        int count = 0;
        do {
            int randomNumber = random.nextInt(9) + 1;
            count = isContainedNumber(returnNumberList, randomNumber) ? count : count + 1;
        } while (count < 3);
        return returnNumberList;
    }

    public boolean isContainedNumber(List<Integer> numberList, int number) {
        if (numberList.contains(number)) {
            return true;
        }
        numberList.add(number);
        return false;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }
}
