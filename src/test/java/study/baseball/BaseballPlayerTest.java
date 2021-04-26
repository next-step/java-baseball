package study.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BaseballPlayerTest {


    @ParameterizedTest
    @DisplayName("숫자의 범위가 정상적이지 않을 경우 예외 출력 확인 테스트")
    @ValueSource(ints = {22, 2929, -1})
    void 숫자범위_정상확인(int sampleNumber) {
        assertThatThrownBy(() -> {
            BaseballPlayer.checkRange(sampleNumber);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("정수가 아닐경우 예외출력 테스트")
    @ValueSource(strings = "test")
    void 정수가_아닐경우_예외처리_확인(String str) throws IOException {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        Scanner sc = new Scanner(is);
        assertThatThrownBy(() -> {
            BaseballPlayer.isNotNumber(sc);
        })
                .isInstanceOf(InputMismatchException.class);
        is.close();
    }


    @ParameterizedTest
    @DisplayName("구성 숫자가 중복 되었을 경우 다시 시작할지 결과 반환 테스트")
    @CsvSource({
            "332, true",
            "214, false",
            "145, false",
            "366, true"
    })
    void 중복_숫자_구성시_다시_시작_여부(int inputNumber, boolean isAgain) {

        assertThat(BaseballPlayer.checkValidNumber(inputNumber))
                .as("게임을 다시 시작해야되는지")
                .isEqualTo(isAgain);
    }
}