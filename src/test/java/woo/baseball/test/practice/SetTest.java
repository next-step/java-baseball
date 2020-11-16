package woo.baseball.test.practice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : chano
 * @Date : 2020. 11. 16.
 * @Description :
 */
public class SetTest {

  private Set<Integer> numbers;

  @BeforeEach
  void setUp1() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @ParameterizedTest
  @ValueSource(ints = { 1, 2, 3 })
  @DisplayName("parameterTest1")
  void parameterTest1(int number) {
    assertThat(numbers.contains(number)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = { 1, 2, 3, 4, 5 })
  @DisplayName("parameterTest2")
  void parameterTest3(int number) {
    assertThat(numbers.contains(number)).isTrue();

  }

}