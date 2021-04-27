package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {
    @Test
    @DisplayName("numbers갯수 3개 정상적으로 입력하였을 때")
    void numberSucceessTest() {
        Numbers numbers = new Numbers(123);
        assertThat(numbers.numbers().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("numbers갯수 3개 이하로 입력하였을 때")
    void numberFailTest() {
        assertThatThrownBy(() -> {
            Numbers numbers = new Numbers(12);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 숫자 갯수가 2개이하로 입력하였습니다.");
    }

    @Test
    @DisplayName("numbers갯수 4개 이상으로 입력하였을 때")
    void numberFailTest2() {
        assertThatThrownBy(() -> {
            Numbers numbers = new Numbers(1234);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 3개 초과입력하셨습니다.");
    }

    @Test
    @DisplayName("중복된 숫자 입력하였을 때")
    void numberFailTest3() {
        assertThatThrownBy(() -> {
            Numbers numbers = new Numbers(122);

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자를 입력하였습니다.");
    }


}
