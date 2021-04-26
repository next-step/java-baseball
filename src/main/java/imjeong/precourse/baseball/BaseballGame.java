package imjeong.precourse.baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Baseball Game.
 * @author In Mook, Jeong
 * @since 2021.04.25
 */
public class BaseballGame {
 private static List<Integer> ANSWER_LIST = new ArrayList<Integer>(); // 상대방(컴퓨터)의 값을 담는 리스트
 private static Scanner SCANNER = null; // 사용자 입력을 위한 Scanner 객체 초기화
 
 /**
  * Start Point
  * @param args
  * @since 2021. 04. 25
  */
 public static void main(String[] args) {
  setScanner();
  playBaseball();
  closeScanner();
 }
 
 /**
  * 사용자가 입력을 받을 수 있도록 Scanner 객체 생성
  * @since 2021. 04. 25
  */
 public static void setScanner() {
  SCANNER = new Scanner(System.in);
 }
 
 /**
  * 야구게임을 종료할 때 Scanner 객체 자원 반납
  * @since 2021. 04. 25
  */
 public static void closeScanner() {
  SCANNER.close();
 }
 
 /**
  * 야구 게임 시작
  * @since 2021. 04. 25
  */
 public static void playBaseball() {
  setBaseballAnswer();
  boolean duringBaseball = true;
  while(duringBaseball) {
   String userAnswer = getUserAnswer();
   if(!isThreeDigitNumbers(userAnswer)) continue;
   duringBaseball = !isGameOver(userAnswer.toCharArray());
  }
 }
 
 /**
  * 상대방(컴퓨터)의 정답 설정<br/>
  * &emsp;- 정답은 1~9 사이의 숫자 중 중복되지 않는 3개의 숫자로 설정
  * @since 2021. 04. 25
  */
 public static void setBaseballAnswer() {
  ANSWER_LIST.clear();
  while(ANSWER_LIST.size() < 3) {
   int answer = (int) (Math.random() * 9 + 1);
   if(!ANSWER_LIST.contains(answer)) ANSWER_LIST.add(answer);
  }
 }
 
 /**
  * 사용자가 입력한 정답 가져오기<br/>
  * &emsp;- 사용자는 1~9 사이의 숫자 중 중복되지 않는 3개의 숫자를 입력.<br/>
  * &emsp;- 올바른 입력 예시) 194, 375, 472<br/>
  * &emsp;- 잘못된 입력 예시) 19, 37 5, 031, 8ab, a12 등<br/>
  * @return - 사용자가 올바르게 입력한 값을 반환
  * @since 2021. 04. 25
  */
 public static String getUserAnswer() {
  System.out.print("숫자를 입력해주세요 : ");
  return getDeduplicatedUserAnswer(SCANNER.next());
 }
 
 /**
  * 입력된 사용자의 값에 중복 값 제거하기<br/>
  * &emsp;- 예시 1) 사용자 입력 값이 123이면 123 값 반환<br/>
  * &emsp;- 예시 2) 사용자 입력 값이 144이면 14 값 반환<br/>
  * @param userAnswer
  * @return - 중복이 제거된 사용자 입력 값을 반환
  * @since 2021. 04. 25
  */
 public static String getDeduplicatedUserAnswer(String userAnswer) {
  String deduplicatedUserAnswer = "";
  char[] userAnswerChars = userAnswer.toCharArray();
  for(char userAnswerChar : userAnswerChars) {
   if(!deduplicatedUserAnswer.contains(userAnswerChar+"")) deduplicatedUserAnswer += userAnswerChar+"";
  }
  return deduplicatedUserAnswer;
 }
 
 /**
  * 사용자가 입력한 값이 3자리 숫자인지 확인<br/>
  * &emsp;- 사용자가 입력한 값이 3자리 숫자면 true, 아니면 false 반환<br/>
  * &emsp;&emsp;- 예시 1) 사용자 입력 값이 123이면 true 반환<br/>
  * &emsp;&emsp;- 예시 2) 사용자 입력 값이 13이면 false 반환<br/>
  * &emsp;&emsp;- 예시 3) 사용자 입력 값이 1234이면 false 반환<br/>
  * &emsp;&emsp;- 예시 4) 사용자 입력 값이 12a이면 false 반환<br/>
  * &emsp;&emsp;- 예시 5) 사용자 입력 값이 abc이면 false 반환<br/>
  * @param userAnswer
  * @return - 사용자가 입력한 값이 3자리 숫자인지 여부 판단
  * @since 2021. 04. 25
  */
 public static boolean isThreeDigitNumbers(String userAnswer) {
  boolean isThreeDigitNumbers = false;
  if(userAnswer.matches("[1-9]{3}")) isThreeDigitNumbers=true;
  return isThreeDigitNumbers;
 }
 
 /**
  * 게임이 종료되었는지 확인<br/>
  * &emsp;- Strike 갯수가 3이면 Game 종료, 아니면 계속 Game 진행
  * @param userAnswerChar
  * @return - Strike 갯수가 3과 일치하면 true, 일치하지 않으면 false 반환
  * @since 2021. 04. 26
  */
 public static boolean isGameOver(char[] userAnswerChar) {
  int strikeCount = checkBaseballResult(userAnswerChar);
  return (strikeCount == 3);
 }
 
 /**
  * 사용자가 입력한 값이 컴퓨터의 값과 일치하는지 확인<br/>
  * &emsp;- 사용자가 입력한 값이 컴퓨터의 값에 포함이 되는 경우<br/>
  * &emsp;&emsp;- 값이 저장된 위치(Index)가 같으면 Strike 갯수 1 증가<br/>
  * &emsp;&emsp;- 값이 저장된 위치(Index)가 같지 않으면 ball 갯수 1 증가<br/>
  * &emsp;- 사용자가 입력한 값이 컴퓨터의 값에 포함되지 않는 경우 Strike=0, ball=0<br/>
  * @param userAnswerChar
  * @return - 총 Strike 갯수 반환
  * @since 2021. 04. 26
  */
 public static int checkBaseballResult(char[] userAnswerChar) {
  int strike = 0, ball = 0;
  for(int i=0; i<userAnswerChar.length; i++) {
   int userAnswer = Character.getNumericValue(userAnswerChar[i]);
   if(ANSWER_LIST.contains(userAnswer) && userAnswer == ANSWER_LIST.get(i)) strike++;
   if(ANSWER_LIST.contains(userAnswer) && userAnswer != ANSWER_LIST.get(i)) ball++;
  }
  return strike;
 }
}
