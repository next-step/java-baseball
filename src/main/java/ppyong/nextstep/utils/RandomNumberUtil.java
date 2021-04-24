package ppyong.nextstep.utils;

import java.util.Random;

public class RandomNumberUtil {
    private final static int RANDOM_MIN_NUMBER = 1;
    private final static int RANDOM_MAX_NUMBER = 9;
    private Random random;
    private int numberLength;

    public RandomNumberUtil (int NumberLength) {
        random = new Random();
        this.numberLength = NumberLength;
    }

    public String createRandomNumber() {
        StringBuilder appender = new StringBuilder();
        boolean isContinue = true;
        while(isContinue) {
            int randomNumber = random.nextInt(RANDOM_MAX_NUMBER + RANDOM_MIN_NUMBER) + RANDOM_MIN_NUMBER;
            isContinue = checkCondition(appender, randomNumber);
        }
        return appender.toString();
    }

    private boolean checkCondition(StringBuilder sb, int randomNum) {
        if(sb.length() >= numberLength) {
            return false;
        }
        if(sb.indexOf(String.valueOf(randomNum)) == -1) {
            sb.append(randomNum);
        }
        return true;
    }
}

