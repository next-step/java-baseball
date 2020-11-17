package edu.example.numberbaseball.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection 관련 Utility 기능을 가진 클래스
 */
public class CollectionUtil {

    private CollectionUtil() {
    }

    public static List<Integer> fillRange(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("start, end는 `start <= end`를 만족해야합니다.");
        }
        List<Integer> integerList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            integerList.add(i);
        }
        return integerList;
    }
}
