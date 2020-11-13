package com.jyjeong.baseball;

public class Computer {

    NumberCheck uniqueNumber = new NumberCheck();

    public int[] createRandom(){
        int[] randomNumber = new int[3];
        for(int i = 0 ; i < randomNumber.length ; i++){
            randomNumber[i] = (int)((Math.random()*9)+1);
        }
        return randomNumber;
    }

    public int[] computerNumber(){
        int[] computerNumber;
        do{
            computerNumber = createRandom();
        }while (!uniqueNumber.uniqueCheck(computerNumber));

        return computerNumber;
    }
}
