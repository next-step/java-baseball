package dev.cobi.logics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dev.cobi.domains.PlayNumber;

/**
 * @author cobiyu
 */
public class RandomNumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    /**
		 * length 만큼의 중복되지 않는 랜덤값을 return
     * 
     * @param length 값의 길이
     * @return 랜덤값
     */
    public String getRandomNumberByLength(int length){
        List<Integer> randomList = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            randomList.add(i);
        }

        Collections.shuffle(randomList);

        StringBuilder number = new StringBuilder();
        for (int i = 0; i < PlayNumber.PLAY_NUMBER_LENGTH; i++) {
            number.append(randomList.get(i));
        }

        return number.toString();
    }
}
