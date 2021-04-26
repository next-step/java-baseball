package BaseBallGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;


public class BaseBallGameTest {

  BaseBallGame baseBallGame = new BaseBallGame();

  @Test
  public void should_return_i_Is_three_true_else_false_and_print() {
    assertThat(baseBallGame.successSetNumberGame(false, 3)).isFalse();
  }

  @Test
  public void should_choose1_Is_return_true() {
    assertThat(baseBallGame.divideToChoose1Or2(false, "1")).isTrue();
  }

  @Test
  public void should_choose2_Is_return_false() {
    assertThat(baseBallGame.divideToChoose1Or2(false, "2")).isFalse();
  }

  @Test
  public void should_return_true_And_generate_newArray() {
    assertThat(baseBallGame.isGameContinue()).isTrue();
    assertThat(baseBallGame.computerNumber).isNotEmpty();
  }

  @Test
  public void should_return_ArrayIstwoLength() {
    assertThat(baseBallGame.compareToArrayNumber(new int[3], new int[3]).length).isEqualTo(2);
  }

  @Test
  public void should_return_samenumber_is_1() {
    assertThat(baseBallGame.compareArray(1, 1)).isEqualTo(1);
  }

  @Test
  public void should_return_diffrentNumber_is_0() {
    assertThat(baseBallGame.compareArray(1, 2)).isEqualTo(0);
  }

  @Test
  public void should_compare_TwoArray_samePosition_And_sameNumber_FirstIndexIsPlus() {
    int[] a = new int[2];
    int[] b = {1, 2, 4};
    int[] c = {1, 3, 5};
    baseBallGame.checkStrikeCount(b, c, a, b.length);
    assertThat(a[0]).isEqualTo(1);
  }

  @Test
  public void should_compare_TwoArray_sameNumber_secondIndexIsPlus() {
    int[] a = new int[2];
    int[] b = {1, 2, 4};
    int[] c = {2, 3, 5};
    baseBallGame.checkBallCount(b, c, a, b.length);
    assertThat(a[1]).isEqualTo(1);
  }

  @Test
  public void should_generate_number_and_numberIs_not_overlapNumber() {
    int[] a = new int[3];
    baseBallGame.generateRandomNumber(a);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      if (map.containsKey(a[i])) {
        map.put(a[i], map.get(a[i]) + 1);
      } else {
        map.put(a[i], 1);
      }
    }
    System.out.println(map.toString());
    assertThat(map.size()).isEqualTo(3);

  }
}
