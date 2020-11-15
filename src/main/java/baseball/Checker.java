package baseball;

import java.util.List;

public class Checker {
  private static int strike = 0;
  private static int ball = 0;

  private List<Integer> answer;

  public Checker(List<Integer> answer) {
    this.answer = answer;
  }

  public void getScore(int[] userNumber) {
    strike = getStrikeCount(userNumber);
    ball = getBallCount(userNumber, strike);
    printScore();
  }

  public int getStrikeCount(int[] userNumber) {
    int strike = 0;
    for(int i = 0; i < userNumber.length; i++) {
      strike += isStrike(userNumber[i], answer.get(i));
    }
    return strike;
  }

  public int isStrike(int user, int answer) {
    return user == answer ? 1 : 0;
  }

  public int getBallCount(int userNumber[], int strike) {
    int ball = 0;
    for(int i = 0; i < userNumber.length; i++) {
      ball += isBall(userNumber[i]);
    }
    ball = ball - strike;
    return ball;
  }

  public int isBall(int user) {
    return answer.contains(user) ? 1 : 0;
  }

  public void printScore() {
    if(strike == 0 && ball == 0) {
      System.out.print(OutputType.NOTHING);
    }
    if(strike != 0) {
      System.out.print(String.format(OutputType.STRIKE, strike));
    }
    if(ball != 0) {
      System.out.print(String.format(OutputType.BALL, ball));
    }
    System.out.println();
  }

}
