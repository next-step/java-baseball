package baseball;

import java.util.Scanner;

public class User {

  public static int guess() {
    Scanner scan = new Scanner(System.in);
    boolean isOnlyNumber = false;
    String input = "";
    while(!isOnlyNumber) {
      System.out.print("숫자를 입력해주세요 : ");
      input = scan.nextLine();
      isOnlyNumber = validateUserInput(input);
    }
    return Integer.parseInt(input);
  }

  public static int[] makeInputToArr(int input) {
    int[] arr = new int[3];
    arr[0] = input / 100;
    arr[1] = input % 100 / 10;
    arr[2] = input % 10;
    return arr;
  }

  public static boolean validateUserInput(String input) {
    if (input.length() != 3 || !input.matches("^[0-9]*$")) {
      System.out.println("숫자를 바르게 입력하세요!");
      return false;
    }
    return true;
  }

}
