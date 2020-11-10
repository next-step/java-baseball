import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class SpringTest {

    @Test
    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    void split_1_2가_잘_분리되는지_테스트() {
        String[] split = "1,2".split(",");

        assertThat(split.length).isEqualTo(2);
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    void split_1만_자를때_1만_포함한_배열로_반환되는지_테스트() {
        String[] split = "1".split(",");

        assertThat(split.length).isEqualTo(1);
        assertThat(split).contains("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환")
    void substring_괄호_제거() {
        String str = "(1,2)";

        String substring = str.substring(1, str.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    void charAt_특정문자_가져오기() {
        String str = "abc";

        char charAt = str.charAt(2);
        assertThat(charAt).isEqualTo('c');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
    void charAt_문자를_가져올_때_위치_값을_벗어나_가져오기() {
        assertThatThrownBy(() -> {
            String str = "abc";
            str.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range");



    }

}
