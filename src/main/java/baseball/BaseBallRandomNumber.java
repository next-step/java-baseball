package baseball;

import com.google.common.annotations.VisibleForTesting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseBallRandomNumber {
    private String number;

    public void initialize() {
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        Collections.shuffle(list);

        this.number = "" + list.get(0) + list.get(1) +list.get(2);
    }

    public int getStrikeCount(String guess) {
        char[] answerArray = number.toCharArray();
        char[] guessArray = guess.toCharArray();

        int strikeCount = 0;
        for (int i=0; i<3; i++) {
            strikeCount += answerArray[i] == guessArray[i] ? 1 : 0;
        }
        return strikeCount;
    }

    public boolean isCorrect(String guess) {
        return number.equals(guess);
    }

    @VisibleForTesting
    String getNumber() {
        return number;
    }

    @VisibleForTesting
    void setNumber(String number) {
        this.number = number;
    }
}
