package dev.cobi.domains;

/**
 * @author cobiyu
 */
public class ResultScore {
  private int strike;
  private int ball;
  
  private static final int MAX_COUNT = 3; // strike, ball의 최대 카운트

  /**
   * constructor
   */
  public ResultScore() {
    strike = 0;
    ball = 0;
  }

  /**
   * MAX_COUNT와 strike가 동일하다면 정답
   * 
   * @return 정답 여부 
   */
  public boolean isCorrect(){
    return strike == MAX_COUNT;
  }

  /**
   * strike, ball count 추가
   * 
   * @param resultType strike,ball 확인 결과
   */
  public void addResultType(ResultType resultType) {
    addResultValidation();
    
    if (resultType.equals(ResultType.STRIKE)) {
      strike++;
    }

    if (resultType.equals(ResultType.BALL)) {
      ball++;
    }
  }

  /**
   * strike, ball validation
   */
  public void addResultValidation(){
    if(strike >= MAX_COUNT){
      throw new IllegalArgumentException("Invalid add result :: max strike");
    }
    if(ball >= MAX_COUNT){
      throw new IllegalArgumentException("Invalid add result :: max ball");
    }
  }

  /**
   * toString()
   * 
   * @return 결과 관련 message
   */
  @Override
  public String toString() {
    if (strike + ball <= 0) {
      return ResultType.NOTHING.getName();
    }

    String message = "";

    if (strike > 0) {
      message += strike + ResultType.STRIKE.getName();
    }
    if (ball > 0) {
      message += ball + ResultType.BALL.getName();
    }

    return message;
  }

  public int getStrike() {
    return strike;
  }

  public int getBall() {
    return ball;
  }
}
