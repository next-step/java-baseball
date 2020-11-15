package view;

import domain.BaseballInputNumber;
import generator.BaseballAnswerNumberGenerator;
import service.BaseballRuleService;

import java.util.List;
import java.util.Scanner;

public class BaseballView {

  private static final Scanner scanner = new Scanner(System.in);
  private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
  private static final String GAME_ENDED_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

  public void start() {
    boolean isAgain = false;
    List<Integer> answerList = getAnswerList();
    while (!isAgain) {
      String input = getInputFromUser();
      BaseballRuleService service = new BaseballRuleService(getInputList(input), answerList);
      isAgain = service.checkStrikeAndBall();
    }
    printClosedAndRestart();
  }

  private String getInputFromUser() {
    System.out.print(INPUT_MESSAGE);
    String input = scanner.next();
    return input;
  }

  private List<Integer> getInputList(String input) {
    BaseballInputNumber inputNumber = new BaseballInputNumber(input);
    return inputNumber.getNumberList();
  }

  private List<Integer> getAnswerList() {
    BaseballAnswerNumberGenerator generator = new BaseballAnswerNumberGenerator();
    List<Integer> aa  = generator.generate(3);
    return aa;
  }

  private void printClosedAndRestart() {
    System.out.println(GAME_ENDED_MESSAGE);
    Scanner scanner = new Scanner(System.in);
    String value = scanner.next();
    if ("1".equals(value)) {
      start();
    }
  }

}
