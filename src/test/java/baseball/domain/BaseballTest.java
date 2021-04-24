package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballTest {

  @Test
  @DisplayName("baseball 의 사이즈가 3이 아니면 illegalArgumentsException")
  void createBaseball_fail_size() {
    List<BaseballNumber> baseballNumbers = Arrays.asList(new BaseballNumber(1), new BaseballNumber(2));

    assertThatIllegalArgumentException()
        .isThrownBy(() -> new BaseBall(baseballNumbers))
        .withMessage(BaseBall.SIZE_ERROR_MESSAGE);
  }

  @Test
  @DisplayName("baseball 을 생성할 때, 동일한값이 있으면, illegalArgumentsException")
  void createBaseball_fail_equals() {
    List<BaseballNumber> baseballNumbers
        = Arrays.asList(new BaseballNumber(1), new BaseballNumber(1), new BaseballNumber(3));

    assertThatIllegalArgumentException()
        .isThrownBy(() -> new BaseBall(baseballNumbers))
        .withMessage(BaseBall.EQUALS_VALUE_ERROR_MESSAGE);
  }
}
