package baseball;

import java.util.Scanner;

public class User {

  public static int[] guess() {
    Scanner scan = new Scanner(System.in);
    boolean isValid = false;
    String input = "";
    while(!isValid) {
      System.out.print("숫자를 입력해주세요 : ");
      input = scan.nextLine();
      isValid = validateUserInput(input);
    }
    return stringToArr(input);
  }

  public static int[] stringToArr(String input) {
    String[] inputArr = input.split("");
    int[] number = new int[InputType.MAX_ANSWER_SIZE];
    for(int i = 0; i < InputType.MAX_ANSWER_SIZE; i++) {
      number[i] = Integer.parseInt(inputArr[i]);
    }
    return number;
  }

  public static boolean validateUserInput(String input) {
    if (input.length() != InputType.MAX_ANSWER_SIZE || !input.matches("^[0-9]*$")) {
      System.out.println("숫자를 바르게 입력하세요!");
      return false;
    }
    if (input.contains("0")) {
      System.out.println("1부터 9까지의 수만 입력하세요!");
      return false;
    }
    return true;
  }

}
