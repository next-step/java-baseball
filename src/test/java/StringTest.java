import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

  @Test
  @DisplayName("\"1,2\"을 ',' 로 split 했을 때 1과 2로 분리")
  public void split_여러값_콤마로_분리 () {
    String input = "1,2";
    String[] result = input.split(",");
    assertThat(result).contains("1", "2");
  }

  @Test
  @DisplayName("\"1\"을 ',' 로 split 했을 때 1만을 포함하는 배열 반환")
  public void split_하나값_콤마로_분리() {
    String input = "1";
    String[] result = input.split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환")
  public void substring_괄포함값_콤마_분리() {
    String input = "(1,2)";
    String result = input.substring(1,4);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다 - 정상 케이스")
  public void charAt_올바른_경우() {
    String input = "abc";
    char[] inputCharArr = input.toCharArray();
    for (int i = 0; i < inputCharArr.length; i++) {
      assertThat(input.charAt(i)).isEqualTo(inputCharArr[i]);
    }
  }

  @Test
  @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다 - 범주를 넘어간 예외 케이스")
  public void charAt_예외인_경우() {
    String input = "abc";
    assertThatThrownBy(() -> {
      input.charAt(input.length());
    }).isInstanceOf(StringIndexOutOfBoundsException.class);
  }
}
