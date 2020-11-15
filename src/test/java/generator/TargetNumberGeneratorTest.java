package generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetNumberGeneratorTest {

  @Test
  @DisplayName("랜덤으로 생성된 숫자 배열을 반환한다.")
  public void generate() {
    // given
    int size = 3;
    // when
    TargetNumberGenerator generator = new TargetNumberGenerator();
    int[] result = generator.generate(size);
    // then
    assertThat(result.length).isEqualTo(size);
  }
}
