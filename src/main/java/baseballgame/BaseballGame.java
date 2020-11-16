package baseballgame;

public class BaseballGame {
  public static final int DIGITS = 3;

  private GameNumbers answer;

  public void init() {
    this.answer = new GameNumbers(GameNumber.createArray(generateAnswer(new DefaultGenerator())));
  }

  public void init(AnswerGenerator generator) {
    this.answer = new GameNumbers(GameNumber.createArray(generateAnswer(generator)));
  }

  public int[] generateAnswer(AnswerGenerator generator) {
    return generator.generate();
  }

  public Result judge(GameNumbers candidate) {
    return answer.compareWith(candidate);
  }

}
