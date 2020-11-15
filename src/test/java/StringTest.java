import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("'1,2'를 ',' 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    public void Test1_1() {
        String source = "1,2";
        String delimiter = ",";

        String[] splitTarget = source.split(delimiter);

        assertThat(splitTarget)
                .isNotEmpty()
                .contains("1", "2");
    }

    @Test
    @DisplayName("'1'을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    public void Test1_2() {
        String source = "1";
        String target = "1";
        String delimiter = ",";

        String[] splitTarget = source.split(delimiter);

        assertThat(splitTarget)
                .isNotEmpty()
                .containsExactly(target);
    }

    @Test
    @DisplayName("'(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 '1,2'를 반환하도록 구현한다.")
    public void Test2_1() {
        String source = "(1,2)";
        String target = "1,2";

        int sourceSize = source.length();
        String subStr = source.substring(0, sourceSize);

        assertThat(subStr).isEqualTo(target);
    }

    @Test
    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습테스트를 구현한다.")
    public void Test3_1() {
        String source = "abc";
        char target = 'a';

        // 정상 호출
        assertThat(source.charAt(0)).isEqualTo(target);
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    public void Test3_2() {
        String source = "abc";

        assertThatThrownBy(() -> {
            // index 오버
            source.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index : 4, Size : 3");
    }

    @Test
    @DisplayName("JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.")
    public void Test3_3() {
        String source = "TEST";
        assertThat(source).isEqualTo("TEST");
    }
}
