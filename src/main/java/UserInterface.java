import java.util.Map;
import java.util.Scanner;

import validator.NumberFormatValidator;

public class UserInterface {
  private final Scanner scanner = new Scanner(System.in);

  private final String[] messages = {
      "숫자를 입력해 주세요",
      "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n\r게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
  };

  public String interactUser() {
    System.out.println(messages[0]);
    String input = scanner.next();
    NumberFormatValidator.validate(input);
    return input;
  }

  public void answerTo(Map<Result, Integer> score) {
    if (score.size() == 0) {
      System.out.println(Result.NOTHING.getMessage());
      return;
    }
    answerTo(convertScoreToMessage(score));
  }

  private void answerTo(String message) {
    if (message.length() == 0) {
      return;
    }
    System.out.println(message);
  }

  protected String convertScoreToMessage(Map<Result, Integer> score) {
    StringBuilder answer = new StringBuilder();
    writeMessageBy(score, Result.STRIKE, answer);
    if (!isInitMessage(answer) && hasNext(score))
      answer.append(" ");
    writeMessageBy(score, Result.BALL, answer);
    return answer.toString();
  }

  private void writeMessageBy(Map<Result, Integer> score, Result resultType, StringBuilder message) {
    if (!score.containsKey(resultType))
      return;
    message.append(score.get(resultType))
        .append(" ")
        .append(resultType.getMessage());
  }

  private boolean isInitMessage(StringBuilder message) {
    return message.length() == 0;
  }

  private boolean hasNext(Map<Result, Integer> score) {
    return score.containsKey(Result.BALL);
  }

}
