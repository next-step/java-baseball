package kr.insup;

import kr.insup.domain.GameOptions;
import kr.insup.domain.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    private static final int TEST_TRIAL = 500;

    @DisplayName("1~9로 이루어진 1자리 숫자를 잘 만들어내는지 확인")
    @RepeatedTest(TEST_TRIAL)
    void 숫자_한개_생성() {
            //given, when
            String strDigit = NumberGenerator.generateDigit();
            int digit = Integer.parseInt(strDigit);
            //then
            assertThat(digit).isGreaterThan(0).isLessThan(10);
    }

    @DisplayName("n자리 숫자로 만들어졌는지 확인")
    @RepeatedTest(TEST_TRIAL)
    void n자리_숫자() {
        //given, when
        String number = NumberGenerator.generateNumber();
        //then
        assertThat(number).hasSize(GameOptions.HOW_MANY_DIGIT);
    }

    @DisplayName("서로 다른 숫자로 만들어졌는지 확인")
    @RepeatedTest(TEST_TRIAL)
    void 서로_다른_숫자() {
        //given
        String number = NumberGenerator.generateNumber();
        //when
        Set<Character> words = getCharacters(number);
        //then
        assertThat(words).hasSize(GameOptions.HOW_MANY_DIGIT);
    }

    Set<Character> getCharacters(String number) {
        Set<Character> words = new HashSet<>();
        for (char c : number.toCharArray()) {
            words.add(c);
        }
        return words;
    }
}
