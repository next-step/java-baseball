package game;

import common.GameOption;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class GameProcessInfo {

    private ArrayList<String> randomNumberArray;
    private Random random;

    public GameProcessInfo(){
        makeGameProcessInfoNumberArray();
    }

    public ArrayList<String> getRandomNumberArray() {
        return randomNumberArray;
    }

    private ArrayList<String> makeGameProcessInfoNumberArray() {

        HashSet<Integer> numberSet = new HashSet<>();

        while (numberSet.size() < GameOption.RANDOM_NUMBER_COUNT) {
            numberSet.add(getRandomNumber());
        }

        randomNumberArray = new ArrayList<>();

        for (Integer number : numberSet) {
            randomNumberArray.add(String.valueOf(number));
        }

        return randomNumberArray;
    }

    private int getRandomNumber() {
        return getRandomInstance().nextInt(9) + 1;
    }

    private Random getRandomInstance() {
        if (random == null) {
            random = new Random();
        }

        return random;
    }
}
