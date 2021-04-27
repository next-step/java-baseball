package util;

import common.Const;

import java.util.*;

public class RandomNumberGenerator {

    public static List<Integer> makeBaseballNumber() {

        Random random = new Random();

        Set<Integer> set = new LinkedHashSet<>();

        while(set.size() < Const.COMPUTER_NUMBER_SIZE) {
            set.add(random.nextInt(Const.RANDOM_MAX_NUMBER)+1);
        }
        return Collections.unmodifiableList(new ArrayList<>(set));
    }
}
