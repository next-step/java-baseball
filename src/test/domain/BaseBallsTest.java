package domain;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseBallsTest {
    private BaseBalls baseBalls;
    private BaseBalls opponent;

    @Test
    @BeforeEach
    void initialize() {
        baseBalls = null;
        opponent = null;
    }

    @DisplayName("세자리 숫자를 담고 있는 baseBalls 객체를 잘 생성하는지 확인")
    @Test
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "135", "123"})
    void checkBaseBallsObjectCreatedWell(String number) {
        int DIGIT = 3;
        baseBalls = new BaseBalls(number);
        assertTrue(baseBalls.getClass() == BaseBalls.class);
    }

    @DisplayName("strike 점수 총합이 0, 1, 2, 3 인 경우에 대해 결과가 잘 나오는지 확인")
    @Test
    @ParameterizedTest
    @CsvSource({"123,3", "124, 2", "145, 1", "341, 0"})
    void checkCalculateTotalStrikeScoreWell(String opponent_one, int score) {
        baseBalls = new BaseBalls("123");
        opponent = new BaseBalls(opponent_one);
        assertTrue(baseBalls.strikeNumber(opponent) == score);
    }



}