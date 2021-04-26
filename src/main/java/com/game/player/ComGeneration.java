package com.game.player;

import java.util.ArrayList;
import java.util.List;

public class ComGeneration implements GenerationUtil {
    private int randomNumber = 0;
    private List<String> numberList = new ArrayList<>();

    @Override
    public List<String> getTargetNumber() {
        while(numberList.size() != 3) {
            String randomNum = getRandomNumber();
            numberList = duplicateArr(numberList,randomNum);
        }
        return numberList;
    }

    private String getRandomNumber() {
        return String.valueOf(this.randomNumber = (int)(Math.random() * 9) + 1);
    }

    private List<String> duplicateArr (List<String> numberList, String targetNumber){
        if(!numberList.contains(targetNumber)){
            numberList.add(targetNumber);
        }
        return numberList;
    }

}
