package game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class GameProcessInfo {

    private ArrayList<String> randomNumberArray;
    private Random random;
    public final int RANDOM_NUMBER_COUNT = 3;

    public GameProcessInfo(){
        makeGameProcessInfoNumberArray();
    }

    public ArrayList<String> getRandomNumberArray() {
        return randomNumberArray;
    }

    public ArrayList<String> makeGameProcessInfoNumberArray() {

        HashSet<Integer> numberSet = new HashSet<>();

        while (numberSet.size() < RANDOM_NUMBER_COUNT) {
            numberSet.add(getRandomNumber());
        }

        randomNumberArray = new ArrayList<>();

        for (Integer number : numberSet) {
            randomNumberArray.add(String.valueOf(number));
        }

        return randomNumberArray;
    }

    private int getRandomNumber() {
        return getRandomInstance().nextInt(8) + 1;
    }

    public Random getRandomInstance() {
        if (random == null) {
            random = new Random();
        }

        return random;
    }
}
