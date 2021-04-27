package study.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseballCalculatorTest {


    @ParameterizedTest
    @DisplayName("두 숫자 비교 후 반환값에 대해서 올바른지 확인 테스트")
    @ValueSource(ints = {245, 369, 532})
    void 두_숫자_비교_후_반환값과_정답_일치여부(int num) {

        assertAll(
                () -> assertTrue(BaseballCalculator.compareNumber(num, num)),
                () -> assertFalse(BaseballCalculator.compareNumber(123, num))
        );

    }

    @ParameterizedTest
    @DisplayName("입력 받은 두 숫자의 스트라이크 계산 확인 테스트")
    @CsvSource({
            "123, 321, 1",
            "467, 467, 3",
            "293, 291, 2",
            "234, 567, 0"
    })
    void 두_숫자_Strike_계산_테스트(int computerNumber, int userNumber, int answer) {
        BaseballCalculator.allocatedNum(computerNumber, userNumber);
        assertEquals(answer, BaseballCalculator.calculateStrike());
    }

    @ParameterizedTest
    @DisplayName("입력 받은 두 숫자의 볼 계산 확인 테스트")
    @CsvSource({
            "132, 321, 3",
            "467, 467, 0",
            "293, 219, 1",
            "438, 324, 2"
    })
    void 두_숫자_Ball_계산_테스트(int computerNumber, int userNumber, int answer) {
        BaseballCalculator.allocatedNum(computerNumber, userNumber);
        assertEquals(answer, BaseballCalculator.calculateBall());
    }

    @ParameterizedTest
    @DisplayName("Strike, Ball 점수에 따른 계속 turn 종료 여부 테스트")
    @CsvSource({
            "3, 0, true",
            "2, 1, false",
            "1, 2, false",
            "0, 3, false"
    })
    void Turn_종료_여부_확인(int strike, int ball, boolean answer) {

        assertEquals(answer, BaseballCalculator.compareResult(strike, ball));
    }


}