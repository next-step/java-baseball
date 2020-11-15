package baseball;

import java.util.Scanner;

public class BaseballGame {

  public void run() {
    boolean isPlay = true;
    while(isPlay) {
      game();
      isPlay = isReplay();
    }
  }

  public void game() {
    boolean isAnswer = false;
    Checker checker = new Checker(Computer.generateAnswer());
    while(!isAnswer) {
      int guessNumber = User.guess();
      checker.getScore(User.makeInputToArr(guessNumber));
      isAnswer = checker.checkAnswer();
    }
  }

  public boolean isReplay() {
    System.out.println(OutputType.REPLAY_GAME);
    Scanner scan = new Scanner(System.in);
    int replay = scan.nextInt();
    return replay == 1 ? true : false;
  }

}
