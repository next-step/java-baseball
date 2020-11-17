package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class BaseballDigitGeneratorTest {

    @Test
    @DisplayName("랜덤 객체에 따라 결과에 영향이 가는지 테스트")
    void generateRandomDigits_랜덤동일성() {
        // given
        List<String> availableChars = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        int digits = 3;
        BaseballDigitGenerator digitGenerator = new BaseballDigitGenerator(availableChars, digits);
        Random random1 = new Random(1);
        Random random2 = new Random(1);
        Random randomDiff = new Random(2);

        // when
        List<String> random1Digits = digitGenerator.generateRandomDigits(random1);
        List<String> random2Digits = digitGenerator.generateRandomDigits(random2);
        List<String> randomDiffDigits = digitGenerator.generateRandomDigits(randomDiff);


        // then
        assertThat(random1Digits).containsSequence(random2Digits);
        assertThat(random1Digits).doesNotContainSequence(randomDiffDigits);
    }

    @Test
    @DisplayName("생성한 randomDigits 가 인자로 받은 digits 만큼 생성하는지 테스트")
    void generateRandomDigits_갯수() {
        // given
        List<String> availableChars = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        int digits = 8;
        BaseballDigitGenerator digitGenerator = new BaseballDigitGenerator(availableChars, digits);

        // when
        List<String> generated = digitGenerator.generateRandomDigits(new Random());

        // then
        assertThat(generated).hasSize(digits);
    }

    @Test
    @DisplayName("입력받은 문자열이 야구게임 조건에 만족하는지 테스트")
    void isValidateInput() {
        // given
        List<String> availableChars = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        int digits = 5;

        // when
        String digitRight_availableNo = "12349";
        String digitNo_availableRight = "1234";
        String digitNo_availableDuplicated = "1233";
        String digitRight_availableRight = "12345";

        // then
        assertThat(BaseballDigitGenerator.isValidateInput(digitRight_availableNo, availableChars, digits)).isFalse();
        assertThat(BaseballDigitGenerator.isValidateInput(digitNo_availableRight, availableChars, digits)).isFalse();
        assertThat(BaseballDigitGenerator.isValidateInput(digitNo_availableDuplicated, availableChars, digits)).isFalse();
        assertThat(BaseballDigitGenerator.isValidateInput(digitRight_availableRight, availableChars, digits)).isTrue();

    }
}