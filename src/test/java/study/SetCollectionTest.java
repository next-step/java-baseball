package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SetCollectionTest {

  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @DisplayName("Set 사이즈 테스트")
  @Test
  void size_test() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @DisplayName("Set 데이터 확인 테스트")
  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void contains_test(String input, String expected) {
    assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(new Boolean(expected));
  }


}
