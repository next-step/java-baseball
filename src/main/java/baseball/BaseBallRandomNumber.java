package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseBallRandomNumber {
    public static final int RANDOM_NUMBER_LENGTH = 3;
    private String number;

    public void initialize() {
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        Collections.shuffle(list);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i< RANDOM_NUMBER_LENGTH; i++) {
            stringBuilder.append(list.get(i));
        }

        this.number = stringBuilder.toString();
    }

    public String getNumber() {
        return number;
    }
}
