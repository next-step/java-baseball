package baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);
  public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
  public static final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";

  public static List<Integer> getNumbers() {
    System.out.print(INPUT_NUMBER_MESSAGE);
    String inputNumbers = SCANNER.nextLine();
    List<Integer> numbers = parseNumbers(inputNumbers);
    return numbers;
  }

  private static List<Integer> parseNumbers(String inputNumbers) {
    String[] splitInput = inputNumbers.split("");
    List<Integer> numbers = new ArrayList<>();
    for (String string : splitInput) {
      numbers.add(Integer.parseInt(string));
    }
    return numbers;
  }

  public static boolean isWantReplay() {
    System.out.println(REPLAY_MESSAGE);
    return SCANNER.nextLine().equals("1");
  }
}
