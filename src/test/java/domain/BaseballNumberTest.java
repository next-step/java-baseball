package domain;

import application.BaseballService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author : byungkyu
 * @date : 2020/11/12
 * @description : 야구게임 각 숫자별 테스트
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BaseballNumberTest {

    private BaseballService baseballService;

    @BeforeEach
    void init() {
        baseballService = new BaseballService();
    }

    @Order(1)
    @ParameterizedTest
    @DisplayName("2.2.1.사용자_숫자_입력/각_숫자들은_1부터_9까지_입력할_수_있다")
    @ValueSource(ints = {1, 5, 9})
    void baseballNumberValidOnZeroToNine(int arg) {
        BaseballNumber baseballNumber = new BaseballNumber(arg);
        assertEquals(arg, baseballNumber.getValue());
    }

    @Order(2)
    @ParameterizedTest
    @DisplayName("2.2.2.사용자_숫자_입력/각_숫자들이_1부터_9까지의_범위를_벗어난_값은_에러발생")
    @ValueSource(ints = {0, 10, 15, 20})
    void baseballNumberValidOnZeroToNineThrowException(int arg) {
        assertThrows(IllegalStateException.class, () -> new BaseballNumber(arg));
    }

    @Order(3)
    @ParameterizedTest
    @DisplayName("2.2.3.사용자_숫자_입력/문자열을_입력할_경우_에러발생")
    @ValueSource(strings = {"asd", "12a", "as4"})
    void baseballNumberInvalidCharacterException(String arg) {
        assertThrows(IllegalStateException.class, () -> new BaseballNumber(arg));
    }
}