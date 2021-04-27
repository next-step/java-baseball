package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void splitTest() {
        // given
        String targetOneTwo = "1,2";
        String targetOne = "1";
        // when
        String[] splitTargetOneTwo = targetOneTwo.split(",");
        String[] splitTargetOne = targetOne.split(",");
        //then
        assertThat(splitTargetOneTwo).contains("1", "2");
        assertThat(splitTargetOne).containsExactly("1");
    }

    @Test
    void subStringTest() {
        // given
        String targetStr = "(1,2)";
        // when
        String subStr = targetStr.substring(1, 4);
        // then
        assertThat(subStr).isEqualTo("1,2");
    }

    @Test
    @DisplayName("IndexOutOfBoundsException throw 테스트")
    void charAtTest() {
        // given
        String target = "abc";
        // when - then
        assertThatThrownBy(() -> target.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("range: 3");

        // when - then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> target.charAt(4))
                .withMessageContaining("range: 4");
    }
}
