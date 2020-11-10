package me.country.component;

import static org.assertj.core.api.Assertions.assertThat;

import me.country.util.NumberUtil;
import org.junit.jupiter.api.Test;

public class ComputerTest {

  @Test
  public void newNumberTest() {
    Computer computer = new Computer();

    int actual = computer.getAnswer();

    assertThat(actual).isGreaterThanOrEqualTo(123);
    assertThat(actual).isLessThanOrEqualTo(987);
    assertThat(NumberUtil.getHundredNumber(actual)).isNotEqualTo(NumberUtil.getTenNumber(actual));
    assertThat(NumberUtil.getTenNumber(actual)).isNotEqualTo(NumberUtil.getOneNumber(actual));
    assertThat(NumberUtil.getOneNumber(actual)).isNotEqualTo(NumberUtil.getHundredNumber(actual));
  }
}
