package me.totoku103.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ComputerTest {

    @ParameterizedTest
    @CsvSource({"1, 5", "1, 2", "1, 3", "1, 9"})
    @DisplayName("랜덤 숫자 메소드 테스트")
    public void generateRandomNumberTest(int min, int max) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method method = Computer.class.getDeclaredMethod("generateRandomNumber", int.class, int.class);
        method.setAccessible(true);

        final int result = (int) method.invoke(new Computer(), min, max);
        assertThat(result)
                .as("Random: %d, min: %d, max: %d", result, min, max)
                .isBetween(min, max);
    }

    @ParameterizedTest
    @CsvSource({"2, 1", "3, 2", "4, 3", "6, 5", "2, 1", "1, 0"})
    @DisplayName("랜덤 숫자 메소드 테스트 min > max")
    public void generateRandomNumberTest_reversedInputMaxAndMinValues(int min, int max) throws NoSuchMethodException {
        final Method method = Computer.class.getDeclaredMethod("generateRandomNumber", int.class, int.class);
        method.setAccessible(true);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    try {
                        method.invoke(new Computer(), min, max);
                    } catch (InvocationTargetException e) {
                        throw e.getTargetException();
                    }
                });
    }


    @ParameterizedTest
    @CsvSource({"-1, 4", "0, 4", "4, 11", "5, 10", "2, 24", "-19, 0"})
    @DisplayName("min, max 허용 범위 테스트 (1~9)")
    public void generateRandomNumberTest_checkPossibleRange(int min, int max) throws NoSuchMethodException {
        final Method method = Computer.class.getDeclaredMethod("generateRandomNumber", int.class, int.class);
        method.setAccessible(true);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    try {
                        method.invoke(new Computer(), min, max);
                    } catch (InvocationTargetException e) {
                        throw e.getTargetException();
                    }
                });
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 3, 3", "2, 5, 3", "1, 9, 3", "2, 4, 2", "1, 3, 1"})
    @DisplayName("랜덤 숫자 문자열 메소드 테스트")
    public void generateRandomDigitStringTest(int min, int max, int length) {
        final Computer computer = new Computer();
        final String result = computer.generateRandomDigitString(min, max, length);

        assertThat(result)
                .describedAs(result)
                .isNotNull();

        assertThat(result)
                .hasSize(length);

        for (int i = 0; i < result.length(); i++) {
            final int intInResultString = Integer.parseInt(String.valueOf(result.charAt(i)));
            assertThat(intInResultString)
                    .isBetween(min, max);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"234, 1", "145, 2", "456, 7"})
    @DisplayName("기존 생성된 랜덤문자열에 생성된 랜덤숫자가 있는지 중복 체크 :: false")
    public void isDuplication_false(String digitString, int randomNumber) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method method = Computer.class.getDeclaredMethod("isDuplication", String.class, int.class);
        method.setAccessible(true);

        final boolean result = (boolean) method.invoke(new Computer(), digitString, randomNumber);
        assertThat(result)
                .isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"234, 2", "234, 3", "234, 4", "567, 6", "523, 2", "523, 3"})
    @DisplayName("기존 생성된 랜덤문자열에 생성된 랜덤숫자가 있는지 중복 체크 :: true")
    public void isDuplication_true(String digitString, int randomNumber) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method method = Computer.class.getDeclaredMethod("isDuplication", String.class, int.class);
        method.setAccessible(true);

        final boolean result = (boolean) method.invoke(new Computer(), digitString, randomNumber);
        assertThat(result)
                .isTrue();
    }

}