package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    /*
     * [요구사항 1]
     * "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     *
     * [힌트]
     * 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
     * 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
     */
    @Test
    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인")
    public void require_1_1() {
        // given
        String strNumber = "1,2";

        // when
        String[] arrNumber = strNumber.split(",");

        // then
        assertThat(arrNumber).contains("1", "2");
        assertThat(arrNumber).containsExactly("1", "2");
        assertThat(arrNumber).doesNotContain(",");
    }

    @Test
    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환")
    public void require_1_2() {
        // given
        String strNumber = "1";

        // when
        String[] arrNumber = strNumber.split(",");

        // then
        assertThat(arrNumber).contains("1");
        assertThat(arrNumber).containsExactly("1");
    }

    /*
     * [요구사항 2]
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환 하도록 구현한다.
     */
    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 substring() 메소드를 활용해 () 을 제거")
    public void require_2() {
        // given
        String strNumber = "(1,2)";

        // when
        String strSubResult = strNumber.substring(1, strNumber.length() - 1);

        // then
        assertThat(strSubResult).isEqualTo("1,2");
    }

    /*
     * [요구사항 3]
     *
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @Test
    @DisplayName("문자열이 주어졌을 때 charAt() 메소드 테스트")
    public void require_3() {
        // given
        String strNumber = "abc";
        int strNumberLength = strNumber.length();

        // then
        assertThatThrownBy(() -> strNumber.charAt(-1)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");

        assertThat(strNumber.charAt(0)).isEqualTo('a');
        assertThat(strNumber.charAt(1)).isEqualTo('b');
        assertThat(strNumber.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> strNumber.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}
