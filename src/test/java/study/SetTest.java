package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
  }

  @DisplayName("Set의 size를 확인")
  @Test
  public void should_return_setSize() {
    assertThat(numbers.size()).isEqualTo(4);
  }

  @DisplayName("Set 1,2,3을 포함하는지 확인")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  public void should_set_Is_contain_123(int number) {
    assertThat(numbers.contains(number)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"true,1", "true,4", "true,4", "true,4", "false,5"})
  public void should_set_is_contain_4_isnot_contain_4true(boolean boo, int b) {
    assertThat(numbers.contains(b)).isEqualTo(boo);
  }
}
