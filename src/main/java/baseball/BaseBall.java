package baseball;

import java.util.HashMap;

import static baseball.GameResult.*;

public class BaseBall {

    public String getRandomValue() {
        String randomValue;
        boolean validateValue;

        do {
            randomValue = String.valueOf((int) (Math.random() * 999 + 100));
            validateValue = validateNumber(randomValue);
        } while (!validateValue);

        return randomValue;
    }

    public boolean validateNumber(String validateToData) {
        boolean isDuplicate = true;
        int i = 0, size = validateToData.length();

        while (isDuplicate && i < size - 1) {
            isDuplicate = validateInLoop(i++, validateToData);
        }

        return isDuplicate;
    }

    public HashMap<GameResult, Integer> play(String attack, String defence) {
        HashMap<GameResult, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < attack.length(); i++) {
            GameResult key = getGameResult(i, attack, defence);
            resultMap.put(key, resultMap.getOrDefault(key, 0) + 1);
        }

        return resultMap;
    }

    public boolean judgeGameResult(HashMap<GameResult, Integer> resultGameMap) {
        return resultGameMap.get(STRIKE) == 3;
    }

    private boolean validateInLoop(int i, String validateToData) {
        boolean checkDuplicateData = true;
        int j = i + 1, size = validateToData.length();

        while (checkDuplicateData && j < size) {
            checkDuplicateData = validateToData.charAt(i) != validateToData.charAt(j++);
        }

        return checkDuplicateData;
    }

    private GameResult getGameResult(int i, String attack, String defence) {
        if (attack.charAt(i) == defence.charAt(i)) {
            return STRIKE;
        }

        if (defence.contains("" + attack.charAt(i))) {
            return BALL;
        }

        return NOTHING;
    }
}
