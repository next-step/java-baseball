package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("요구사항1 : \"1,2\"을 public class StringTest {로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    public void splitTest1() {
        String str = "1,2";
        String[] strArray = str.split(",");

        String[] expected = {"1", "2"};

        assertThat(strArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("요구사항1 : \"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다. ")
    public void splitTest2() {
        String str = "1";
        String[] strings = str.split(",");

        String[] expected = {"1"};

        assertThat(strings).isEqualTo(expected);
    }


}
