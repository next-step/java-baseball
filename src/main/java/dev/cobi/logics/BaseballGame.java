package dev.cobi.logics;

import dev.cobi.domains.PlayNumber;
import dev.cobi.domains.ResultScore;
import dev.cobi.view.BaseballGameView;

/**
 * @author cobiyu
 */
public class BaseballGame {
  private final BaseballGameView baseballGameView;
  private final Referee referee;
  private final RandomNumberGenerator randomNumberGenerator;

  /**
   * constructor
   * 
   * @param baseballGameView 입출력 관련
   * @param referee strike, ball 판단
   * @param randomNumberGenerator 랜덤값 생성
   */
  public BaseballGame(BaseballGameView baseballGameView,
                      Referee referee,
                      RandomNumberGenerator randomNumberGenerator) {
    this.baseballGameView = baseballGameView;
    this.referee = referee;
    this.randomNumberGenerator = randomNumberGenerator;
  }

  /**
   * 랜덤값 생성
   * 
   * @return 랜덤값
   */
  public PlayNumber generateRandomNumber(){
    return new PlayNumber(
            randomNumberGenerator.getRandomNumberByLength(PlayNumber.PLAY_NUMBER_LENGTH)
    );
  }

  /**
   * 게임 시작
   * 
   * 1. 게임 결과 ResultScore의 isCorrect()가 true일때까지 진행
   * 2. 정답일 경우 retry
   */
  public void play(){
    PlayNumber answerNumber = generateRandomNumber();
    boolean isCorrect;

    do {
      PlayNumber inputPlayNumber = getInputPlayNumber();
      
      ResultScore resultScore = getResultScoreBy(answerNumber, inputPlayNumber);
      
      baseballGameView.displayResult(resultScore);
      
      isCorrect = resultScore.isCorrect();
      
    } while (!isCorrect);

    retry();
  }

  /**
   * 값 입력
   * 
   * @return 입력한 값
   */
  public PlayNumber getInputPlayNumber() {
    String inputPlayNumber = baseballGameView.inputPlayNumber();

    PlayNumber playNumber = new PlayNumber(inputPlayNumber);
    playNumber.inputNumberValidationCheck();

    return playNumber;
  }

  /**
   * strike, ball 판단
   * 
   * @param answerNumber 정답
   * @param playNumber 입력한 값
   * @return 결과
   */
  public ResultScore getResultScoreBy(PlayNumber answerNumber, PlayNumber playNumber){
    return referee.getResultScore(answerNumber, playNumber);
  }

  /**
   * 재시작
   * 
   * baseballGameView 에서 재시작 여부를 물은 뒤 true일경우 재시작
   */
  public void retry(){
    if(baseballGameView.isRestart()){
      play();
    }
  }

}
