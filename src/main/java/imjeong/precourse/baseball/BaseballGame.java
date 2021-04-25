package imjeong.precourse.baseball;

import java.util.ArrayList;
import java.util.List;

/**
 * Baseball Game.
 * @author In Mook, Jeong
 * @since 2021.04.25
 */
public class BaseballGame {
 private static List<Integer> ANSWER_LIST = new ArrayList<Integer>();

 /**
  * Start Point
  * @param args
  * @since 2021. 04. 25
  */
 public static void main(String[] args) {
  playBaseball();
 }

 /**
  * 야구 게임 시작
  * @since 2021. 04. 25
  */
 public static void playBaseball() {
  setBaseballAnswer();
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
}
