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

  @Test
  public void convertToListTest() {
    MainApplication mainApplication = new MainApplication();
    char[] test1 = {'1', '2', '3'};
    char[] test2 = {'2', '3', '4'};

    assertThat(mainApplication.convertToList(test1)).hasSize(3).contains('1', '2', '3');
    assertThat(mainApplication.convertToList(test2)).hasSize(3).contains('2', '3', '4');
  }

  @Test
  public void generateRandomNumberTest() {
    MainApplication mainApplication = new MainApplication();
    assertThat(mainApplication.generateRandomNumber(3)).hasSize(3).doesNotHaveDuplicates();
  }

  @Test
  public void validateStrikeTest() {
    List<Character> testRandomNumber1 = new LinkedList<>(Arrays.asList('1', '2', '3'));
    List<Character> testInputNumber1 = new LinkedList<>(Arrays.asList('1', '2', '3'));
    List<Character> testRandomNumber2 = new LinkedList<>(Arrays.asList('1', '2', '3'));
    List<Character> testInputNumber2 = new LinkedList<>(Arrays.asList('1', '2', '4'));
    List<Character> testRandomNumber3 = new LinkedList<>(Arrays.asList('1', '2', '3'));
    List<Character> testInputNumber3 = new LinkedList<>(Arrays.asList('4', '1', '2'));

    MainApplication mainApplication = new MainApplication();
    assertThat(mainApplication.validateStrike(testRandomNumber1, testInputNumber1)).isEqualTo(3);
    assertThat(mainApplication.validateStrike(testRandomNumber2, testInputNumber2)).isEqualTo(2);
    assertThat(mainApplication.validateStrike(testRandomNumber3, testInputNumber3)).isEqualTo(0);
  }
}
