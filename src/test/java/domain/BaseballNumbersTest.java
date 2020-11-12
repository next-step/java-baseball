package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : byungkyu
 * @date : 2020/11/12
 * @description : 야구게임 전체숫자 테스트
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BaseballNumbersTest {

    @Order(1)
    @ParameterizedTest
    @DisplayName("2.1.1.사용자_숫자_입력/전체_입력값들은_각각_1부터_9까지_입력할_수_있다")
    @ValueSource(strings = {"159", "319", "235"})
    void baseballNumbersValidOnZeroToNine(String arg) {
        BaseballNumbers baseballNumbers = new BaseballNumbers(arg);
        for (BaseballNumber baseballNumber : baseballNumbers.getValues()) {
            assertTrue(baseballNumber.getValue() >= BaseballNumbers.MINIMUM_NUMBER_OF_BASEBALL_GAME);
            assertTrue(baseballNumber.getValue() <= BaseballNumbers.MAXIMUM_NUMBER_OF_BASEBALL_GAME);
        }
    }

    @Order(2)
    @ParameterizedTest
    @DisplayName("2.1.2.사용자_숫자_입력/전체_입력값들은_각각_1부터_9까지_입력할_수_있다_벗어난_값은_에러발생")
    @ValueSource(strings = {"109", "310", "035"})
    void baseballNumbersValidOnZeroToNineException(String arg) {
        assertThrows(IllegalStateException.class, () -> new BaseballNumbers(arg));
    }

    @Order(3)
    @ParameterizedTest
    @DisplayName("2.1.3.사용자_숫자_입력/전체_입력값들은_각각_서로_다른_수이다")
    @ValueSource(strings = {"123", "345", "942"})
    void baseballNumbersAllDifferent(String arg) {
        Set<Integer> numberStructure = new HashSet<>();
        BaseballNumbers baseballNumbers = new BaseballNumbers(arg);
        for (BaseballNumber baseballNumber : baseballNumbers.getValues()) {
            numberStructure.add(baseballNumber.getValue());
        }
        assertEquals(arg.length(), numberStructure.size());
        assertEquals(arg.length(), baseballNumbers.size());
        assertEquals(arg.length(), BaseballNumbers.NUMBER_OF_BASEBALL_GAME);
    }

    @Order(4)
    @ParameterizedTest
    @DisplayName("2.1.4.사용자_숫자_입력/전체_입력값들은_각각_서로_다른_수이다_같은_수가_있으면_에러발생")
    @ValueSource(strings = {"121", "335", "944"})
    void baseballNumbersAllDifferentException(String arg) {
        assertThrows(IllegalStateException.class, () -> new BaseballNumbers(arg));
    }

    @Order(5)
    @ParameterizedTest
    @DisplayName("2.1.5.사용자_숫자_입력/전체_입력값들은_3자리수이다")
    @ValueSource(strings = {"523", "127", "428"})
    void baseballNumbersLengthIsThree(String arg) {
        BaseballNumbers baseballNumbers = new BaseballNumbers(arg);
        assertEquals(arg.length(), baseballNumbers.size());
        assertEquals(arg.length(), BaseballNumbers.NUMBER_OF_BASEBALL_GAME);
    }

    @Order(6)
    @ParameterizedTest
    @DisplayName("2.1.6.사용자_숫자_입력/전체_입력값들은_3자리수이다_3자리수가_아닐_경우_에러발생")
    @ValueSource(strings = {"1211", "3355", "9441123"})
    void baseballNumbersLengthIsThreeException(int arg) {
        assertThrows(IllegalStateException.class, () -> new BaseballNumber(arg));
    }
}