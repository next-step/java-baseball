package baseball.domain;

import baseball.util.BaseballException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("플레이어_입력_테스트")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BaseballNumbersTest {

    @Order(1)
    @ParameterizedTest
    @DisplayName("1.숫자가_아닌_문자_입력_예외_확인")
    @ValueSource(strings = {"a12", "b123", "c1234", "1ㄱ2", "1@3", "12ㄷ", "46ㄹ"})
    void testAboutPlayerInputType(String arg) {
        assertThrows(BaseballException.IllegalPlayerInputType.class, () -> new BaseballNumbers(arg));
    }

    @Order(2)
    @ParameterizedTest
    @DisplayName("2.숫자_입력_범위_예외_확인")
    @ValueSource(strings = {"012", "304", "560"})
    void testAboutPlayerInputBoundary(String arg) {
        assertThrows(BaseballException.IllegalPlayerInputBoundary.class, () -> new BaseballNumbers(arg));
    }

    @Order(3)
    @ParameterizedTest
    @DisplayName("3.숫자_입력_길이_예외_확인")
    @ValueSource(strings = {"1", "23", "4567", "78912"})
    void testAboutPlayerInputLength(String arg) {
        assertThrows(BaseballException.IllegalPlayerInputLength.class, () -> new BaseballNumbers(arg));
    }

    @Order(4)
    @ParameterizedTest
    @DisplayName("4.중복된_숫자_예외_확인")
    @ValueSource(strings = {"111", "223", "454","566"})
    void testAboutDuplicatePlayerInput(String arg) {
        assertThrows(BaseballException.IllegalDuplicatePlayerInput.class, () -> new BaseballNumbers(arg));
    }

    @Order(5)
    @ParameterizedTest
    @DisplayName("5.올바른_입력값_정상처리_확인")
    @ValueSource(strings = {"154", "246", "375","489"})
    void testAboutCorrectPlayerInput(String arg) {
        // Given
        BaseballNumbers baseballNumbers = new BaseballNumbers(arg);
        List<String> argList = Arrays.asList(arg.split(""));

        // When
        List<String> valuesInBaseballNumbers = baseballNumbers.getValues();

        //Then
        assertEquals(argList, valuesInBaseballNumbers);
    }

}