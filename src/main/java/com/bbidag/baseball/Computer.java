package com.bbidag.baseball;

import java.util.Random;

public class Computer {
    private final Random random;
    private int[] numbers;

    public Computer(Random random){
        this.random = random;
    }

    public int[] generateRandomNumbers(){
        int[] newNumbers = new int[3];

        for(int idx=0; idx<3; idx++){
            newNumbers[idx] = numberWithoutDuplicate(newNumbers);
        }

        return newNumbers;
    }

    public int numberWithoutDuplicate(int[] newNumbers){
        int newNumber = 0;

        do{
            newNumber = random.nextInt(9) + 1;
        } while(hasDuplicatedNumber(newNumbers, newNumber));

        return newNumber;
    }

    public boolean hasDuplicatedNumber(int[] newNumbers, int newNumber){
        boolean isDuplicated = false;

        for(int number : newNumbers){
            isDuplicated = isDuplicated || number == newNumber;
        }

        return isDuplicated;
    }

    public void setNumbers(int[] numbers){
        this.numbers = numbers;
    }

    public int[] getNumbers(){
        return this.numbers;
    }

}
