package com.nextstep.ppyong.validator;

import java.util.HashSet;
import java.util.Set;

public class DuplicatedNumberValidator implements Validator {
    @Override
    public boolean valid(String input) {
        Set<Character> checkSet = new HashSet<>();
        int idx = 0;
        int cnt = 0;
        while(idx < input.length() && checkSet.add(input.charAt(idx))) {
            cnt++;
            idx++;
        }
        if(cnt != input.length()) {
            throw new RuntimeException("유효한 숫자가 아닙니다. 1-9의 '3자리' 정수를 입력해주세요.");
        }
        return true;
    }
}
