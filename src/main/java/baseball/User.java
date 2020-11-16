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
    int number = Integer.parseInt(input);
    int[] arr = new int[3];
    arr[0] = number / 100;
    arr[1] = number % 100 / 10;
    arr[2] = number % 10;
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
