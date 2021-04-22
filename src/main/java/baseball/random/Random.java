package baseball.random;

import baseball.domain.Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Random {
    List<String> list = new ArrayList(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

    default Numbers getRandomNumber(int limit) {
        return new Numbers(take(shuffle(list), limit));
    }

    List shuffle(List<String> list);

    default List take(List<String> list, int limit) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            newList.add(list.get(i));
        }
        return newList;
    }
}
