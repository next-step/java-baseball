package com.nextstep.ppyong.validator;

public class OnlyNumberValidator implements Validator{
    @Override
    public boolean valid(String input) {
        char[] charArr = input.toCharArray();
        int idx = 0;
        int cnt = 0;
        while(idx < input.length() && Character.isDigit(charArr[idx])) {
            cnt++;
            idx++;
        }
        if(cnt != input.length()) {
            throw new RuntimeException("유효한 숫자가 아닙니다. 1-9의 '3자리' 정수를 입력해주세요.");
        }
        return true;
    }
}
