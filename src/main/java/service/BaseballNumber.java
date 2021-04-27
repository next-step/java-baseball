package service;

import java.util.LinkedHashSet;
import java.util.Set;

public class BaseballNumber {
    public int[] getBaseballNumber(){
        int[] baseballNumber = new int[3];
        Set<Integer> randomNumber = new LinkedHashSet<>();
        while(randomNumber.size() < 3){
            randomNumber.add((int)(Math.random() * 9 + 1));
        }

        int i = 0;
        for (int r: randomNumber) {
            baseballNumber[i++] = r;
        }

        return baseballNumber;
    }
}
