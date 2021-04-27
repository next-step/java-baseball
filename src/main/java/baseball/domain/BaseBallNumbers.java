package baseball.domain;

import baseball.util.CollectionUtil;

import java.util.Collection;

public abstract class BaseBallNumbers {
  private static final int DIGIT = 3;
  private static final String ERROR_DIGIT_FORMAT = "베이스 볼 숫자는 중복되지 않는 %d 자릿수 숫자만 허용됩니다.";

  protected BaseBallNumbers(Collection<Number> values) {
    checkDigit(values);
  }

  private void checkDigit(Collection<Number> values) {
    if (CollectionUtil.isEmpty(values) || values.size() != DIGIT) {
      throw new IllegalArgumentException(String.format(ERROR_DIGIT_FORMAT, DIGIT));
    }
  }
}
