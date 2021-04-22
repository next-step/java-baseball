package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {

    @DisplayName("3개의 숫자가 위치까지 똑같다면 둘은 같은 Numbers 객체이다")
    @Test
    void equals() {
        final Numbers numbers1 = new Numbers(new ArrayList(Arrays.asList("1", "2", "3")));
        final Numbers numbers2 = new Numbers(new ArrayList(Arrays.asList("1", "2", "3")));
        assertThat(numbers1).isEqualTo(numbers2);
    }

    @DisplayName("3자리의 숫자가 아니라면 IllegalArgumentException이 발생한다")
    @Test
    void sizeTest() {
        assertThatThrownBy(() -> {
            new Numbers(new ArrayList(Arrays.asList("1", "2", "3", "4")));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있다면 IllegalArgumentException이 발생한다")
    @Test
    void duplicateTest() {
        assertThatThrownBy(() -> {
            new Numbers(new ArrayList(Arrays.asList("1", "1", "3")));
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
