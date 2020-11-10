package me.country.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtilTest {

  @ParameterizedTest
  @ValueSource(ints = {359, 314, 327})
  public void getHundredNumberTest(int i) {
    assertThat(NumberUtil.getHundredNumber(i)).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {359, 152, 953})
  public void getTenNumberTest(int i) {
    assertThat(NumberUtil.getTenNumber(i)).isEqualTo(5);
  }

  @ParameterizedTest
  @ValueSource(ints = {359, 129, 749})
  public void getOneNumberTest(int i) {
    assertThat(NumberUtil.getOneNumber(i)).isEqualTo(9);
  }
}
