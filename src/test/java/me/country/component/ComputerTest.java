package me.country.component;

import static org.assertj.core.api.Assertions.assertThat;

import me.country.util.NumberUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerTest {

  private Computer computer;

  @BeforeEach
  public void setUp() {
    computer = new Computer();
  }

  @Test
  public void answerTest() {
    int actual = computer.getAnswer();

    assertThat(actual).isGreaterThanOrEqualTo(123);
    assertThat(actual).isLessThanOrEqualTo(987);
    assertThat(NumberUtil.getHundredNumber(actual)).isNotEqualTo(NumberUtil.getTenNumber(actual));
    assertThat(NumberUtil.getTenNumber(actual)).isNotEqualTo(NumberUtil.getOneNumber(actual));
    assertThat(NumberUtil.getOneNumber(actual)).isNotEqualTo(NumberUtil.getHundredNumber(actual));
  }

  @Test
  public void calcTest() {
    int answer = computer.getAnswer();

    computer.calc(answer);
  }

  @Test
  public void printNothingTest() {
    computer.printResult();
  }

  @Test
  public void print3StrikeTest() {
    computer.calc(computer.getAnswer());

    computer.printResult();
  }

  @Test
  public void isIngTest() {
    int answer = computer.getAnswer();

    boolean ing = computer.isIng(answer);

    assertThat(ing).isEqualTo(false);
  }
}
