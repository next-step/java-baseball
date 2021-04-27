package utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.assumingThat;

class ValidCheckTest {

    @ParameterizedTest
    @ValueSource(strings = {"2333a","abc","2뮻5","010","123"})
    void isNumeric(String s) {
        assumingThat(
                ValidCheck.isNumeric(s),
                () -> System.out.println(s + ":test success!"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"233333","34","3","123"})
    void validLength(String s) {
        assumingThat(
                ValidCheck.validLength(s, 3),
                () -> System.out.println(s + ":test success!"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"233333","34","3","1223","123"})
    void hasDuplicate(String s) {
        assumingThat(
                ValidCheck.hasDuplicate(s),
                () -> System.out.println(s + ":test success!"));
    }
}