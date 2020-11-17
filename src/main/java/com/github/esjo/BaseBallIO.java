package com.github.esjo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

import com.github.esjo.domain.Rule;

public class BaseBallIO {
    private static String input = "";
    private static BufferedReader bufferedReader;
    private static BaseBallIO baseBallIO;

    private BaseBallIO() {
    }

    /**BaseBallIO객체 초기화 정적 메서드 - 사용자 입력 값을 받기 위한 변수 세팅
     * @return baseBallIO 객체 생성
     * */
    public static BaseBallIO createBaseBallIO(InputStream inputStream) {
        baseBallIO = new BaseBallIO();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return baseBallIO;
    }

    /**
     * 야구게임을 위한 유효한 3자리 정수를 입력받는 함수
     * @return String 유효한 3자리 정수
     * @Exception 해당 입력값이 유효하지 않은 이유를 메세지로 던짐
     * */
    public String readThreeDigits() throws Exception {
        do {
            this.input = bufferedReader.readLine();
        } while (!this.baseBallIO.isValidateThreeDigits());
        return this.input;
    }

    /**
     * 입력값 유효성 검증 - readThreeDigits
     * */
    private boolean isValidateThreeDigits() throws Exception {
        this.baseBallIO.isInteger()
                .isRightLength(Rule.NUMBER_OF_DIGITS.getValue())
                .isInRange(Rule.MIN.getValue(), Rule.MAX.getValue())
                .isNotDuplicate();
        return true;
    }

    /**
     * 입력값의 숫자형식 검증
     * */
    private BaseBallIO isInteger() {
        try {
            Integer.parseInt(this.input);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException("[Tip] 숫자 형식만 입력 가능합니다.");
        }
        return this;
    }

    /**
     * 입력값의 자리수 검증
     * */
    private BaseBallIO isRightLength(int lenght) {
        if (this.input.length() != lenght) {
            throw new IllegalArgumentException("[Tip] " + lenght + "자리의 숫자를 입력해야 합니다.");
        }
        return this;
    }

    /**
     * 각자리수의 숫자 범위 검증
     * */
    private BaseBallIO isInRange(int min, int max) {
        for (int i = 0; i < this.input.length(); i++) {
            int tmp = Integer.parseInt(this.input.charAt(i) + "");
            if (min > tmp || max < tmp) {
                throw new IllegalArgumentException("[Tip] " + min + "이상 " + max + "이하의 숫자만 입력가능 합니다.");
            }
        }
        return this;
    }

    /**
     * 각자리숫자의 중복여부 검증
     * */
    private BaseBallIO isNotDuplicate() {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < this.input.length(); i++) {
            set.add(this.input.charAt(i));
        }
        if (set.size() < this.input.length()) {
            throw new IllegalArgumentException("[Tip] 각 자리수는 서로 달라야 합니다.");
        }
        return this;
    }
}
