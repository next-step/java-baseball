package precourse.baseball.referee;

import org.junit.jupiter.api.Test;
import precourse.baseball.printer.PrintMessage;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static precourse.baseball.printer.PrintMessage.BALL;
import static precourse.baseball.printer.PrintMessage.STRIKE;

class RefereeTest {

  @Test
  void givenAnswerAndExpect_whenJudgedByReferee_then0S0B() {
    // Given
    Referee referee = new Referee(new Strike(), new Ball());
    Set<Integer> answer = new TreeSet<>(Arrays.asList(1, 2, 3));
    int[] expect = {7, 8, 9};

    // When
    Map<PrintMessage, Point> judgeResult = referee.judge(expect, answer);

    // Then
    assertEquals(0, judgeResult.get(STRIKE).getCnt());
    assertEquals(0, judgeResult.get(BALL).getCnt());
  }

  @Test
  void givenAnswerAndExpect_whenJudgedByReferee_then1S0B() {
    // Given
    Referee referee = new Referee(new Strike(), new Ball());
    Set<Integer> answer = new TreeSet<>(Arrays.asList(1, 2, 3));
    int[] expect = {1, 8, 9};

    // When
    Map<PrintMessage, Point> judgeResult = referee.judge(expect, answer);

    // Then
    assertEquals(1, judgeResult.get(STRIKE).getCnt());
    assertEquals(0, judgeResult.get(BALL).getCnt());
  }

  @Test
  void givenAnswerAndExpect_whenJudgedByReferee_then2S0B() {
    // Given
    Referee referee = new Referee(new Strike(), new Ball());
    Set<Integer> answer = new TreeSet<>(Arrays.asList(1, 2, 3));
    int[] expect = {1, 2, 9};

    // When
    Map<PrintMessage, Point> judgeResult = referee.judge(expect, answer);

    // Then
    assertEquals(2, judgeResult.get(STRIKE).getCnt());
    assertEquals(0, judgeResult.get(BALL).getCnt());
  }

  @Test
  void givenAnswerAndExpect_whenJudgedByReferee_then3S0B() {
    // Given
    Referee referee = new Referee(new Strike(), new Ball());
    Set<Integer> answer = new TreeSet<>(Arrays.asList(1, 2, 3));
    int[] expect = {1, 2, 3};

    // When
    Map<PrintMessage, Point> judgeResult = referee.judge(expect, answer);

    // Then
    assertEquals(3, judgeResult.get(STRIKE).getCnt());
    assertEquals(0, judgeResult.get(BALL).getCnt());
  }

  @Test
  void givenAnswerAndExpect_whenJudgedByReferee_then0S1B() {
    // Given
    Referee referee = new Referee(new Strike(), new Ball());
    Set<Integer> answer = new TreeSet<>(Arrays.asList(1, 2, 3));
    int[] expect = {2, 9, 7};

    // When
    Map<PrintMessage, Point> judgeResult = referee.judge(expect, answer);

    // Then
    assertEquals(0, judgeResult.get(STRIKE).getCnt());
    assertEquals(1, judgeResult.get(BALL).getCnt());
  }

  @Test
  void givenAnswerAndExpect_whenJudgedByReferee_then1S1B() {
    // Given
    Referee referee = new Referee(new Strike(), new Ball());
    Set<Integer> answer = new TreeSet<>(Arrays.asList(1, 2, 3));
    int[] expect = {2, 9, 3};

    // When
    Map<PrintMessage, Point> judgeResult = referee.judge(expect, answer);

    // Then
    assertEquals(1, judgeResult.get(STRIKE).getCnt());
    assertEquals(1, judgeResult.get(BALL).getCnt());
  }

  @Test
  void givenAnswerAndExpect_whenJudgedByReferee_then2S1B() {
    // Given
    Referee referee = new Referee(new Strike(), new Ball());
    Set<Integer> answer = new TreeSet<>(Arrays.asList(1, 2, 3));
    int[] expect = {3, 2, 3};

    // When
    Map<PrintMessage, Point> judgeResult = referee.judge(expect, answer);

    // Then
    assertEquals(2, judgeResult.get(STRIKE).getCnt());
    assertEquals(1, judgeResult.get(BALL).getCnt());
  }

  @Test
  void givenAnswerAndExpect_whenJudgedByReferee_then0S2B() {
    // Given
    Referee referee = new Referee(new Strike(), new Ball());
    Set<Integer> answer = new TreeSet<>(Arrays.asList(1, 2, 3));
    int[] expect = {2, 3, 9};

    // When
    Map<PrintMessage, Point> judgeResult = referee.judge(expect, answer);

    // Then
    assertEquals(0, judgeResult.get(STRIKE).getCnt());
    assertEquals(2, judgeResult.get(BALL).getCnt());
  }

  @Test
  void givenAnswerAndExpect_whenJudgedByReferee_then1S2B() {
    // Given
    Referee referee = new Referee(new Strike(), new Ball());
    Set<Integer> answer = new TreeSet<>(Arrays.asList(1, 2, 3));
    int[] expect = {2, 3, 3};

    // When
    Map<PrintMessage, Point> judgeResult = referee.judge(expect, answer);

    // Then
    assertEquals(1, judgeResult.get(STRIKE).getCnt());
    assertEquals(2, judgeResult.get(BALL).getCnt());
  }

  @Test
  void givenAnswerAndExpect_whenJudgedByReferee_then0S3B() {
    // Given
    Referee referee = new Referee(new Strike(), new Ball());
    Set<Integer> answer = new TreeSet<>(Arrays.asList(1, 2, 3));
    int[] expect = {3, 1, 2};

    // When
    Map<PrintMessage, Point> judgeResult = referee.judge(expect, answer);

    // Then
    assertEquals(0, judgeResult.get(STRIKE).getCnt());
    assertEquals(3, judgeResult.get(BALL).getCnt());
  }
}
