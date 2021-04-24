package com.nextstep.ppyong.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberUtilTest {

    @Test
    @DisplayName("중복되지 않는 0이상 랜덤 숫자 생성 테스트")
    void nonDuplicateNumberTest() {
        RandomNumberUtil randomNumberUtil = new RandomNumberUtil(3);
        String random = randomNumberUtil.createRandomNumber();
        assertTrue(checkDuplicatedNumber(random));
        assertTrue(random.matches("^[1-9]{3}$"));
    }

    private boolean checkDuplicatedNumber(String input) {
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
