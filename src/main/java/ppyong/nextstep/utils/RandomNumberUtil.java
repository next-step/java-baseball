package ppyong.nextstep.utils;

import java.util.Random;

public class RandomNumberUtil {
    private final static int RANDOM_MIN_NUMBER = 1;
    private final static int RANDOM_MAX_NUMBER = 9;
    private Random random;

    public RandomNumberUtil () {
        random = new Random();
    }

    public String createRandomNumber(int count) {
        StringBuilder appender = new StringBuilder();
        boolean isContinue = true;
        while(isContinue) {
            int randomNumber = random.nextInt(RANDOM_MAX_NUMBER + RANDOM_MIN_NUMBER) + RANDOM_MIN_NUMBER;
            isContinue = checkCondition(count, appender, randomNumber);
        }
        return appender.toString();
    }

    private boolean checkCondition(int count, StringBuilder sb, int randomNum) {
        if(sb.length() >= count) {
            return false;
        }
        if(sb.indexOf(String.valueOf(randomNum)) == -1) {
            sb.append(randomNum);
        }
        return true;
    }
}

