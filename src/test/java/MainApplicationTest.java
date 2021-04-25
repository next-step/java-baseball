import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MainApplicationTest {
  @Test
  public static void main(String[] args) {}

  @Test
  public void validateInputNumberTest() {
    MainApplication mainApplication = new MainApplication();
    List<Character> test1 = new LinkedList<>(Arrays.asList('1', '2', '3'));
    List<Character> test2 = new LinkedList<>(Arrays.asList('1', '1', '2'));
    List<Character> test3 = new LinkedList<>(Arrays.asList('1', '1', '1'));
    List<Character> test4 = new LinkedList<>(Arrays.asList('0', '2', '3'));

    assertThat(mainApplication.validateInputNumber(test1)).isEqualTo(true);
    assertThat(mainApplication.validateInputNumber(test2)).isEqualTo(false);
    assertThat(mainApplication.validateInputNumber(test3)).isEqualTo(false);
    assertThat(mainApplication.validateInputNumber(test4)).isEqualTo(false);
  }
}
