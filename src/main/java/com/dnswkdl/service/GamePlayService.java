package com.dnswkdl.service;

public class GamePlayService {

    ImplGamePlayService implGamePlayService = (compare, input)->{return (compare==input?1:0);};

    public int[] check(int answer, int input){
        /** result[0] = strike, result[1] = ball */
        int[] result = {0,0};

        int[] ansArray = toArray(answer);
        int[] inpArray = toArray(input);
        for(int i = 0 ; i < ansArray.length; i++){
            result[0] += implGamePlayService.compareTo(ansArray[i], inpArray[i%3]);
            result[1] += implGamePlayService.compareTo(ansArray[i], inpArray[(i+1)%3]);
            result[1] += implGamePlayService.compareTo(ansArray[i], inpArray[(i+2)%3]);
        }
        return result;
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
