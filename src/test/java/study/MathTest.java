package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class MathTest {
  @Test
  @DisplayName("제곱 테스트")
  void test() throws Exception {
    double pow = Math.pow(10, 2);
    assertThat(pow).isEqualTo(100);
  }
}
