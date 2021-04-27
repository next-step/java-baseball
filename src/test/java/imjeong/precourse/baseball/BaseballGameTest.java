package imjeong.precourse.baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 야구게임 기능 단위 테스트<br/>
 * @author In Mook, Jeong
 * @since 2021.04.25
 */
public class BaseballGameTest {
 private static List<Integer> ANSWER_LIST = new ArrayList<Integer>();
 
 @BeforeAll
 @DisplayName("Setting computer's baseball answer")
 static void setBaseballAnswer() {
  while(ANSWER_LIST.size() < 3) {
   int answer = (int) (Math.random() * 9 + 1);
   if(!ANSWER_LIST.contains(answer)) ANSWER_LIST.add(answer);
  }
 }
 
 @Test
 @DisplayName("Test checking deduplicate computer's baseball answer")
 void testCheckDuplicateBaseballAnswers() {
  for(int i=0; i<ANSWER_LIST.size()-1; i++) {
   for(int j=i+1; j<ANSWER_LIST.size(); j++ ) {
    assertNotEquals(ANSWER_LIST.get(i), ANSWER_LIST.get(j));
   }
  }
 }
 
 @Test
 @DisplayName("Checks whether the value stored in the computer's baseball answer is a number from 1 to 9")
 void testRegexBaseballAnswers() {
  for(int answer : ANSWER_LIST) {
   boolean matched = (answer+"").matches("[1-9]");
   assertTrue(matched);
  }
 }
 
 @ParameterizedTest
 @CsvSource(value = {"123:true", "12:false", "240:false", "1ab:false", "bac:false",}, delimiter = ':')
 @DisplayName("Check the user's input value is 3 digit numbers")
 void testIsUserAnswerThreeNumbers(String userAnswer, boolean expected) {
  assertEquals(userAnswer.matches("[1-9]{3}"), expected);
 }
}
