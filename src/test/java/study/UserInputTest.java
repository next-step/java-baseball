package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class UserInputTest {

  int userInputValue = 0;
  BaseballRandomValueGenerator generator;

  @BeforeEach
  void setUp() {
    generator = new BaseballRandomValueGenerator();
    userInputValue = generator.toInt();
  }

  @Test
  @DisplayName("랜덤숫자를 섞은 이후 값을 비교한다.")
  void testShuffle() throws Exception {
    List<Integer> splitUserInputValue = BaseballUtil.splitNumber(userInputValue);
    System.out.println("splitUserInputValue = " + splitUserInputValue);

    generator.shuffle();

    List<Integer> randomValue = generator.getValue();
    System.out.println("randomValue = " + randomValue);

    assertThat(randomValue).contains(splitUserInputValue.get(0));
    assertThat(randomValue).contains(splitUserInputValue.get(1));
    assertThat(randomValue).contains(splitUserInputValue.get(2));
  }
}
