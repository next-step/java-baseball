package dev.cobi.logics;

import dev.cobi.domains.PlayNumber;
import dev.cobi.domains.ResultScore;
import dev.cobi.domains.ResultType;

/**
 * @author cobiyu
 */
public class Referee {

  /**
   * 정답, 입력값 비교
   * 
   * @param answerNumber 정답
   * @param playNumber 입력값
   * @return 결과 ResultScore
   */
  public ResultScore getResultScore(PlayNumber answerNumber, PlayNumber playNumber){
    ResultScore resultScore = new ResultScore();

    for (int i = 0; i < answerNumber.getNumber().length(); i++) {
      char current = playNumber.getNumber().charAt(i);
      resultScore.addResultType(getResultTypeByString(answerNumber, current, i));
    }
    
    return resultScore;
  }

  /**
   * 숫자별 검증
   * 
   * @param answerNumber 정답
   * @param checkSingleNumberChar 검증할 숫자
   * @param checkIndex 검증할 index
   * @return strike, ball 정보 ResultType 
   */
  public ResultType getResultTypeByString(PlayNumber answerNumber, char checkSingleNumberChar, int checkIndex) {
    String stringAnswerNumber = answerNumber.getNumber();
    
    if (stringAnswerNumber.charAt(checkIndex) == checkSingleNumberChar) {
      return ResultType.STRIKE;
    }

    if (stringAnswerNumber.contains(String.valueOf((checkSingleNumberChar)))) {
      return ResultType.BALL;
    }

    return ResultType.NOTHING;
  }
}
