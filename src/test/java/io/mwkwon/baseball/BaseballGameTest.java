package io.mwkwon.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


/**
 * executeGame method 테스트 class
 *
 * @author  mwkwon
 * @version 1.0: 최초 구현
 *
 */
public class BaseballGameTest {

    private BaseBallGame baseBallGame;

    @BeforeEach
    void setUp() {
        baseBallGame = new BaseBallGame();
    }

    @ParameterizedTest
    @DisplayName("validInputString method 사용자 입력 값 정상 데이터 여부 판단 테스트")
    @CsvSource(value = {
            "'':[1-9]{3}:3:false"
            , "333:[1-9]{3}:3:false"
            , "123:[1-9]{3}:3:true"
            , "1243:[1-9]{3}:3:false"
            , "가3:[1-9]{3}:3:false"
            , "023:[1-9]{3}:3:false"
            , "1:[1-2]{1}:1:true"
            , "2:[1-2]{1}:1:true"
            , "가나아ㅏ:[1-2]{1}:1:false"
            , "3:[1-2]{1}:1:false"
    }, delimiter = ':')
    void validInputStringTest(String inputString, String regex, int strLength, boolean expected) {
        boolean valid = baseBallGame.validInputString(inputString, regex, strLength);
        assertThat(valid).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("isContinueGame method의 parameter 값이 1 또는 2가 아닌 경우 IllegalArgumentException throw 테스트")
    @ValueSource(strings = {"0", "3", "4"})
    void isContinueGameThrowIllegalArgumentExceptionTest(String continueFlag) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> baseBallGame.isContinueGame(continueFlag))
                .withMessage("continueFlag 값은 1 또는 2만 허용합니다.");

    }

    @ParameterizedTest
    @DisplayName("isContinueGame method 입력값에 따른 true, false 정상 반환 여부 테스트")
    @CsvSource(value = {"1,true", "2,false"})
    void continueGameTest(String continueFlag, boolean expected) {
        assertThat(baseBallGame.isContinueGame(continueFlag)).isEqualTo(expected);
    }
}
