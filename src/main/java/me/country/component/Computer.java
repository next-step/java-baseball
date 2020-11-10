package me.country.component;

import java.util.LinkedHashSet;
import java.util.Set;
import me.country.util.NumberUtil;

public class Computer {

  private final Set<Integer> numbers;
  private int answer;
  private int hundredNumber;
  private int tenNumber;
  private int oneNumber;
  private int strike;
  private int ball;

  public Computer() {
    this.numbers = new LinkedHashSet<>();
    makeThreeNumber();
    splitNumbers();
  }

  private void makeThreeNumber() {
    while (numbers.size() < 3) {
      int element = (int) (Math.random() * 9) + 1;
      numbers.add(element);
    }
  }

  private void splitNumbers() {
    StringBuilder temp = new StringBuilder();
    for (int num : numbers) {
      temp.append(num);
    }
    answer = Integer.parseInt(temp.toString());
    hundredNumber = NumberUtil.getHundredNumber(answer);
    tenNumber = NumberUtil.getTenNumber(answer);
    oneNumber = NumberUtil.getOneNumber(answer);
  }

  public int getAnswer() {
    return answer;
  }

  public void calc(int inputNumber) {
    int inputHundredNumber = NumberUtil.getHundredNumber(inputNumber);
    int inputTenNumber = NumberUtil.getTenNumber(inputNumber);
    int inputOneNumber = NumberUtil.getOneNumber(inputNumber);

    calcStrike(inputHundredNumber, inputTenNumber, inputOneNumber);
    calcBall(inputHundredNumber, inputTenNumber, inputOneNumber);
  }

  private void calcStrike(int inputHundredNumber, int inputTenNumber, int inputOneNumber) {
    int strike = 0;
    if (inputHundredNumber == hundredNumber) {
      strike++;
    }
    if (inputTenNumber == tenNumber) {
      strike++;
    }
    if (inputOneNumber == oneNumber) {
      strike++;
    }
    this.strike = strike;
  }

  private void calcBall(int inputHundredNumber, int inputTenNumber, int inputOneNumber) {
    int ball = 0;
    if (inputHundredNumber != hundredNumber && numbers.contains(inputHundredNumber)) {
      ball++;
    }
    if (inputTenNumber != tenNumber && numbers.contains(inputTenNumber)) {
      ball++;
    }
    if (inputOneNumber != oneNumber && numbers.contains(inputOneNumber)) {
      ball++;
    }
    this.ball = ball;
  }

  public void printResult() {
    if (strike == 0 && ball == 0) {
      System.out.println("낫싱");
      return;
    }
    if (strike != 0) {
      System.out.print(strike + " 스트라이크 ");
    }
    if (ball != 0) {
      System.out.print(ball + " 볼");
    }
    if (strike == 3) {
      System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    System.out.println();
  }

  public boolean isIng(int inputNumber) {
    return inputNumber != answer;
  }
}
