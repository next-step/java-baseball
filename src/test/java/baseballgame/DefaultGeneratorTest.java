package baseballgame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DefaultGeneratorTest {
  AnswerGenerator generator = new DefaultGenerator();

  @Test
  @DisplayName("all numbers must be in the range \'1~9\'")
  void numberRangeTest() {
    for (int i = 0; i < 100000; i++) {
      checkOutOfBound(generator.generate());
    }
  }

  @Test
  @DisplayName("no duplication")
  void duplicationTest() {
    for (int i = 0; i < 100000; i++) {
      checkDuplication(generator.generate());
    }
  }

  void checkOutOfBound(int[] arr) {
    for (int i : arr) {
      assertThat(i).isBetween(1, 9);
    }
  }

  void checkDuplication(int[] arr) {
    assertThat(arr).doesNotHaveDuplicates();
  }

  @Test
  @DisplayName("randomness test")
  void randomnessTest() {
    int samples = 999999;
    int[] frequency = new int[9];
    for (int i = 0; i < samples; i++) {
      record(generator.generate(), frequency);
    }
    checkDistribution(frequency, samples);
  }

  void record(int[] arr, int[] data) {
    for (int i : arr) {
      data[i - 1]++;
    }
  }

  void checkDistribution(int[] data, int samples) {
    for (int i : data) {
      assertThat(i).isBetween((int) (samples / 3 * 0.9), (int) (samples / 3 * 1.1));
    }
  }
}
