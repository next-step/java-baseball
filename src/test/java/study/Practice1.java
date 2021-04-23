package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Practice1 {

    @Test
    @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void split() {

        // given
        String input = "1,2";
        String[] expected = {"1", "2"};

        // when
        String[] split = input.split(",");

        // then
        assertThat(split)
                .containsExactly(expected);
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하도록 구현한다.")
    void substring() {

        // given
        String input = "1,2";
        String[] expected = {"1", "2"};

        // when
        String[] split = input.split(",");

        // then
        assertThat(split)
                .containsExactly(expected);
    }
}
