package com.dnswkdl.service;

public class GamePlayService {
    public int checkStrike(int answer, int input){
        int strike = 0;
        int[] ansArray = toArray(answer);
        int[] inpArray = toArray(input);
        for(int i = 0 ; i < ansArray.length; i++){
            if(ansArray[i]==inpArray[i]){
                strike++;
            }
        }
        return strike;
    }
    public int checkBall(int answer, int input){
        int ball = 0;
        return ball;
    }
    private int[] toArray(int number){
        int[] result = {0,0,0};

        int first = number/100;
        int second = (number - first*100)/10;
        int third = (number - first*100)%10;
        result[0] = first;
        result[1] = second;
        result[2] = third;

        return result;
    }

}
