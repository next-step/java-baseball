package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {

  @Test
  @DisplayName("[Computer] 1부터 9까지 서로 다른 3자리 수 생성 기능 테스트")
  void generateAnswerTest() {
    List<Integer> answer = Computer.generateAnswer();
    assertThat(answer.size()).isEqualTo(3);
    assertThat(answer.get(0) == answer.get(1)).isEqualTo(false);
    assertThat(answer.get(1) == answer.get(2)).isEqualTo(false);
    assertThat(answer.get(2) == answer.get(0)).isEqualTo(false);
  }

}