package baseball;

import java.util.ArrayList;

public class BaseBall {

    public ArrayList<Integer> getRandomValue() {
        ArrayList<Integer> randomValueArray = new ArrayList<>();

        do {
            int randomValue = (int) (Math.random() * 9 + 1);
            boolean isDuplicateValue = checkDuplicateValue(randomValueArray, randomValue);
            insertValue(isDuplicateValue, randomValueArray, randomValue);
        } while (randomValueArray.size() < 3);

        return randomValueArray;
    }

    public boolean checkDuplicateValue(ArrayList<Integer> randomValueArray, int randomValue) {
        return randomValueArray.size() == 0 || !randomValueArray.contains(randomValue);
    }

    private void insertValue(boolean isDuplicateValue, ArrayList<Integer> randomValueArray, int randomValue) {
        if (isDuplicateValue) {
            randomValueArray.add(randomValue);
        }
    }

}
