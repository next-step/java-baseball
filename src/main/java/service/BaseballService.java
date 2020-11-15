package service;

import java.util.HashMap;
import java.util.Map;

public class BaseballService {

	public static final int SCORE_MAX_LENGTH = 3;
	public static final int SCORE_MIN_NUM = 1;
	public static final int SCORE_MAX_NUM = 9;

	private int[] gameMasterScore = new int[SCORE_MAX_LENGTH];
	private Map<Enum, Integer> scoreMap = new HashMap<>();

	public int[] getGameMasterScore() {
		return gameMasterScore;
	}

	public Map<Enum, Integer> getScoreMap() {
		return scoreMap;
	}

	public boolean playUntilEnd(String inputScore) {
		if (!isValidInputScore(inputScore)) {
			return false;
		}
		generateGameMasterScore();
		setScoreResult(inputScore);
		System.out.println(getScoreResultMessage());

		return getGameResult();
	}

	public void setScoreResult(String inputScore) {
		for (int i = 0; i < inputScore.length(); i++) {
			int inputScoreAt = Integer.parseInt(inputScore.charAt(i) + "");
			setScoreResult(i, inputScoreAt);
		}
	}

	public void setScoreResult(int inputScoreIndex, int inputScoreAt) {
		for (int i = 0; i < SCORE_MAX_LENGTH; i++) {
			setScoreResultToMap(i, inputScoreIndex, inputScoreAt);
		}
	}

	/**
	 * 입력된 숫자의 자리와 값이 마스터 스코어와 동일한지 여부에 따라 스크라이크 또는 볼을 결정한다.
	 */
	public void setScoreResultToMap(int masterScoreIndex, int inputScoreIndex, int inputScoreAt) {
		if (gameMasterScore[masterScoreIndex] == inputScoreAt && masterScoreIndex == inputScoreIndex) {
			scoreMap.put(BaseballCount.STRIKE, scoreMap.getOrDefault(BaseballCount.STRIKE, 0) + 1);
		}
		if (gameMasterScore[masterScoreIndex] == inputScoreAt && masterScoreIndex != inputScoreIndex) {
			scoreMap.put(BaseballCount.BALL, scoreMap.getOrDefault(BaseballCount.BALL, 0) + 1);
		}
	}

	public boolean isValidInputScore(String inputScore) {
		return inputScore.trim().length() == 3;
	}

	public void generateGameMasterScore() {
		for (int i = 0; i < SCORE_MAX_LENGTH; i++) {
			gameMasterScore[i] = getRandomNumberUsingInts();
		}
	}

	public int getRandomNumberUsingInts() {
		return (int)(Math.random() * SCORE_MAX_NUM + SCORE_MIN_NUM);
	}

	public String getScoreResultMessage() {
		int strikeCount = scoreMap.getOrDefault(BaseballCount.STRIKE, 0);
		int ballCount = scoreMap.getOrDefault(BaseballCount.BALL, 0);

		if (strikeCount > 0 || ballCount > 0) {
			return getValidScoreMessage(strikeCount, ballCount);
		}
		return BaseballCount.NOTHING.getName();
	}

	public void initScoreMap() {
		scoreMap.put(BaseballCount.STRIKE, 0);
		scoreMap.put(BaseballCount.BALL, 0);
	}

	private boolean getGameResult() {
		return scoreMap.getOrDefault(BaseballCount.STRIKE, 0) == SCORE_MAX_LENGTH;
	}

	private String getValidScoreMessage(int strikeCount, int ballCount) {
		StringBuilder resultMessage = new StringBuilder();
		if (strikeCount > 0) {
			resultMessage.append(strikeCount).append(BaseballCount.STRIKE.getName());
		}
		if (ballCount > 0) {
			resultMessage.append(ballCount).append(BaseballCount.BALL.getName());
		}
		return resultMessage.toString();
	}
}
