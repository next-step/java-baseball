package baseball.judge;

import static baseball.BaseBallApplication.*;

import java.util.ArrayList;
import java.util.List;

public class JudgeServiceImpl implements JudgeService {

	private final String FOUR_BALL = "포볼";

	@Override
	public Judge judgeQuestion(List<Integer> answer, List<String> question) {
		if (fourBallByIncorrectInputData(question)) {
			return new Judge(FOUR_BALL, false);
		}
		BallCount ballCount = new BallCount(0, 0);
		for (int i = 0; i < question.size(); i++) {
			compareWithAnswer(ballCount, answer, question.get(i), i);
		}
		String ballCountMessage = getBallCountMessage(ballCount);
		return new Judge(ballCountMessage, ballCount.getStrike() == BALL_COUNT);
	}

	private boolean fourBallByIncorrectInputData(List<String> question) {
		if (question.size() < 1) {
			return true;
		}
		if (question.get(0).isEmpty() && question.size() == 1) {
			return true;
		}
		return false;
	}

	private void compareWithAnswer(BallCount ballCount, List<Integer> answer, String questionNumber,
		int questionIndex) {
		if (!Character.isDigit(questionNumber.charAt(0))) {
			return;
		}
		for (int j = 0; j < answer.size(); j++) {
			computeBallCount(ballCount, answer, j, questionNumber, questionIndex);
		}
	}

	private void computeBallCount(BallCount ballCount, List<Integer> answer, int answerIndex, String questionNumber,
		int questionIndex) {
		if (Integer.parseInt(questionNumber) != answer.get(answerIndex)) {
			return;
		}
		if (questionIndex == answerIndex) {
			ballCount.increaseStrike();
			return;
		}
		ballCount.increaseBall();
	}

	private String getBallCountMessage(BallCount ballCount) {
		if (ballCount.getStrike() == 0 && ballCount.getBall() == 0) {
			return FOUR_BALL;
		}
		ArrayList<String> messages = new ArrayList<>();
		if (ballCount.getStrike() > 0) {
			messages.add(ballCount.getStrike() + " 스트라이크");
		}
		if (ballCount.getBall() > 0) {
			messages.add(ballCount.getBall() + " 볼");
		}
		return String.join(" ", messages);
	}
}
