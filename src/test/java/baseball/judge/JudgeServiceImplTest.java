package baseball.judge;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.AppConfig;

class JudgeServiceImplTest {

	JudgeService judgeService;

	@BeforeEach
	void beforeEach() {
		AppConfig appConfig = new AppConfig();
		judgeService = appConfig.judgeService();
	}

	@Test
	@DisplayName("입력받은 질문 값이 정답인지 확인한다")
	void judgeQuestionTest() {
		List<Integer> answer = Arrays.asList(1, 2, 3);
		List<String> question1 = Arrays.asList("3", "4", "5");
		List<String> question2 = Arrays.asList("1", "2", "3");

		Judge judgeFail = judgeService.judgeQuestion(answer, question1);
		Judge judgeSuccess = judgeService.judgeQuestion(answer, question2);

		assertThat(judgeFail.isSuccess()).isFalse();
		assertThat(judgeFail.getMessage()).isEqualTo("1 볼");
		assertThat(judgeSuccess.isSuccess()).isTrue();
		assertThat(judgeSuccess.getMessage()).isEqualTo("3 스트라이크");
	}

	@Test
	@DisplayName("질문입력값이 비정상일경우를 체크하여 true 정상일경우 false를 리턴해준다")
	void fourBallByIncorrectInputDataTest() {
		List<String> question1 = Arrays.asList("");
		List<String> question2 = Arrays.asList();
		List<String> question3 = Arrays.asList("1", "2");
		try {
			Method fourBallByIncorrectInputData = judgeService.getClass()
				.getDeclaredMethod("fourBallByIncorrectInputData", List.class);
			fourBallByIncorrectInputData.setAccessible(true);

			Object failCase1 = fourBallByIncorrectInputData.invoke(judgeService, question1);
			Object failCase2 = fourBallByIncorrectInputData.invoke(judgeService, question2);
			Object successCase = fourBallByIncorrectInputData.invoke(judgeService, question3);

			assertThat(failCase1).isEqualTo(true);
			assertThat(failCase2).isEqualTo(true);
			assertThat(successCase).isEqualTo(false);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("주어진 숫자로 볼카운트를 계산한다. 정답객체 전체탐색")
	void compareWithAnswerTest() {
		BallCount ballCount1 = new BallCount(0, 0);
		BallCount ballCount2 = new BallCount(0, 0);
		BallCount ballCount3 = new BallCount(0, 0);

		List<Integer> answer = Arrays.asList(1, 2, 3);

		try {
			Method computeBallCount = judgeService.getClass()
				.getDeclaredMethod("compareWithAnswer", BallCount.class, List.class, String.class, int.class);
			computeBallCount.setAccessible(true);

			computeBallCount.invoke(judgeService, ballCount1, answer, "1", 0);
			computeBallCount.invoke(judgeService, ballCount2, answer, "1", 1);
			computeBallCount.invoke(judgeService, ballCount3, answer, "4", 1);

			assertTrue(ballCount1.getStrike() == 1 && ballCount1.getBall() == 0);
			assertTrue(ballCount2.getStrike() == 0 && ballCount2.getBall() == 1);
			assertTrue(ballCount3.getStrike() == 0 && ballCount3.getBall() == 0);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("주어진 숫자로 볼카운트를 계산한다. 정답객체 특정인덱스 탐색")
	void computeBallCountTest() {
		BallCount ballCount1 = new BallCount(0, 0);
		BallCount ballCount2 = new BallCount(0, 0);
		BallCount ballCount3 = new BallCount(0, 0);

		List<Integer> answer = Arrays.asList(1, 2, 3);

		try {
			Method computeBallCount = judgeService.getClass()
				.getDeclaredMethod("computeBallCount", BallCount.class, List.class, int.class, String.class, int.class);
			computeBallCount.setAccessible(true);

			computeBallCount.invoke(judgeService, ballCount1, answer, 0, "1", 0);
			computeBallCount.invoke(judgeService, ballCount2, answer, 0, "1", 1);
			computeBallCount.invoke(judgeService, ballCount3, answer, 0, "4", 1);

			assertTrue(ballCount1.getStrike() == 1 && ballCount1.getBall() == 0);
			assertTrue(ballCount2.getStrike() == 0 && ballCount2.getBall() == 1);
			assertTrue(ballCount3.getStrike() == 0 && ballCount3.getBall() == 0);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	@DisplayName("볼카운트 메세지 확인 테스트")
	void ballCountMessageTest() {
		BallCount ballCount1 = new BallCount(2, 1);
		BallCount ballCount2 = new BallCount(2, 0);
		BallCount ballCount3 = new BallCount(0, 1);
		BallCount ballCount4 = new BallCount(0, 0);
		try {
			Method ballCountMessage = judgeService.getClass()
				.getDeclaredMethod("getBallCountMessage", BallCount.class);
			ballCountMessage.setAccessible(true);

			Object resultMessage1 = ballCountMessage.invoke(judgeService, ballCount1);
			Object resultMessage2 = ballCountMessage.invoke(judgeService, ballCount2);
			Object resultMessage3 = ballCountMessage.invoke(judgeService, ballCount3);
			Object resultMessage4 = ballCountMessage.invoke(judgeService, ballCount4);

			assertTrue(resultMessage1.equals("2 스트라이크 1 볼"));
			assertTrue(resultMessage2.equals("2 스트라이크"));
			assertTrue(resultMessage3.equals("1 볼"));
			assertTrue(resultMessage4.equals("포볼"));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
