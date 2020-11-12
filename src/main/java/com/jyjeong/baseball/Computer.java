package com.jyjeong.baseball;

public class Computer {

    public int[] CreateRandom(){
        int[] randomNumber = new int[3];
        for(int i = 0 ; i < randomNumber.length ; i++){
            randomNumber[i] = (int)((Math.random()*9)+1);
        }

        return randomNumber;
    }
}
