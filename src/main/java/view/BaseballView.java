package view;

import domain.BaseballInputNumber;

import java.util.List;
import java.util.Scanner;

public class BaseballView {

  private static final Scanner scanner = new Scanner(System.in);
  private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

  public static void start() {
    System.out.print(INPUT_MESSAGE);
    String input = scanner.next();
    BaseballInputNumber baseballInputNumber = new BaseballInputNumber(input);
    List<Integer> inputList = baseballInputNumber.getNumberList();
  }

}
