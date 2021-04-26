package com.dnswkdl.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamePlayService {

    ImplGamePlayService implGamePlayService = (compare, input)->{return (compare==input?1:0);};

    public List<Integer> getAnswer(){
        /* 1,2,3,4,5,6,7,8,9 Collection shuffle, subList(0,2) */
        List<Integer> resource = new ArrayList<>();
        for (int i = 1; i < 10; i++){
            resource.add(i);
        }
        Collections.shuffle(resource);

        return resource.subList(0,3);
    }
    public int[] check(List<Integer> answer, List<Integer> input){
        /* result[0] = strike, result[1] = ball */
        int[] result = {0,0};

        for(int i = 0 ; i < answer.size(); i++){
            result[0] += implGamePlayService.compareTo(answer.get(i), input.get(i%3));
            result[1] += implGamePlayService.compareTo(answer.get(i), input.get((i+1)%3));
            result[1] += implGamePlayService.compareTo(answer.get(i), input.get((i+2)%3));
        }
        return result;
    }
}
