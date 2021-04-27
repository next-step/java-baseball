package game.baseball.util.generator;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumberGenerator {
    final int MAX_VALUE = 9;
    final int MIN_VALUE = 1;

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_VALUE) + MIN_VALUE;
    }
    public ArrayList<Integer> getRandomNumberList(int size) {
        ArrayList<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() != size) {
            addNumberIntoList(randomNumberList, getRandomNumber());
        }
        return randomNumberList;
    }
    public void addNumberIntoList(ArrayList<Integer> list, int randomNumber) {
        boolean duplicationStatus = checkDuplication(list, randomNumber);
        if (!duplicationStatus) {
            list.add(randomNumber);
        }
    }
    public boolean checkDuplication(ArrayList<Integer> list, int randomNumber) {
        return list.contains(randomNumber);
    }

}
