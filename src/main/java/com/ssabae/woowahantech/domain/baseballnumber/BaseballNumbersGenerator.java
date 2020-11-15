package com.ssabae.woowahantech.domain.baseballnumber;

import java.util.*;

import static com.ssabae.woowahantech.Constant.GAME_NUMBER_SIZE;
import static com.ssabae.woowahantech.Constant.GAME_MAX_NUMBER;
import static com.ssabae.woowahantech.Constant.GAME_MIN_NUMBER;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-13
 */
public class BaseballNumbersGenerator {

    private final Random random = new Random();

    public BaseballNumbers generate() {
        Set<Integer> numberSet = generateNotDuplicatedNumberSet();
        List<Integer> list = new ArrayList<>(numberSet);
        return new BaseballNumbers(list);
    }

    protected Set<Integer> generateNotDuplicatedNumberSet() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < GAME_NUMBER_SIZE) {
            set.add(generateBoundedRandomNumber());
        }
        return set;
    }

    protected Integer generateBoundedRandomNumber() {
        return random.nextInt(GAME_MAX_NUMBER) + GAME_MIN_NUMBER;
    }
}
