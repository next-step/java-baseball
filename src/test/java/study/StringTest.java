package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("split 메소드 테스트")
    void splitTest() {

        // given
        String splitTarget1 = "1,2";
        String splitTarget2 = "1";

        // when
        String[] splitResult1 = splitTarget1.split(",");
        String[] splitResult2 = splitTarget2.split(",");

        // then
        assertThat(splitResult1).contains("1", "2");
        assertThat(splitResult1).containsExactly("1", "2");

        assertThat(splitResult2).contains("1");
        assertThat(splitResult2).containsExactly("1");
    }

    @Test
    @DisplayName("substring 메소드 테스트")
    void substringTest() {

        // given
        String substringTarget = "(1,2)";

        // when
        String substringResult = substringTarget.substring(1, substringTarget.length()-1);

        // then
        assertThat(substringResult).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드 테스트: 특정위치의 문자 가져오기")
    void charAtTest_gettingTargetIndex() {

        // given
        String targetSring = "abc";

        // when
        char charResult = targetSring.charAt(1);

        // then
        assertThat(charResult).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt 메소드 테스트: 위치값 벗어날 때 예외발생")
    void charAtTest_indexOut() {

        // given
        String targetSring = "abc";

        // when then
        Assertions.assertThatThrownBy(() -> {

            try {
                char charResult = targetSring.charAt(3);
                System.out.println("charResult = " + charResult);
            } catch (IndexOutOfBoundsException iobe) {
                throw new IndexOutOfBoundsException("Test Input: Index: 3, Size: 3");
            }

        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("Index: 3, Size: 3")
        ;

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {

                try {
                    char charResult = targetSring.charAt(3);
                    System.out.println("charResult = " + charResult);
                } catch (IndexOutOfBoundsException iobe) {
                    throw new IndexOutOfBoundsException("Index: 3, Size: 3");
                }

            }).withMessageMatching("Index: \\d+, Size: \\d+")
        ;
    }
}
