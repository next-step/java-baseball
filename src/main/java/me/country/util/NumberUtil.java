package me.country.util;

public final class NumberUtil {

  private NumberUtil() {
  }

  public static int getHundredNumber(int number) {
    return number / 100;
  }

  public static int getTenNumber(int number) {
    return number / 10 % 10;
  }

  public static int getOneNumber(int number) {
    return number % 100 % 10;
  }
}
