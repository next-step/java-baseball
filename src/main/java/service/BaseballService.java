package service;

public class BaseballService {

	public static final int SCORE_MAX_LENGTH = 3;
	public static final int SCORE_MIN_NUM = 1;
	public static final int SCORE_MAX_NUM = 9;
	private int[] gameMasterScore = new int[SCORE_MAX_LENGTH];

	public int[] getGameMasterScore() {
		return gameMasterScore;
	}

	public boolean playUntilEnd(String inputScore) {
		if (!isValidInputScore(inputScore)) {
			return false;
		}
		generateGameMasterScore();

		return true;
	}

	public boolean isValidInputScore(String inputScore) {
		return inputScore.trim().length() == 3;
	}

	public void generateGameMasterScore() {
		for (int i = 0; i< SCORE_MAX_LENGTH; i++) {
			gameMasterScore[i] = getRandomNumberUsingInts();
		}
	}

	public int getRandomNumberUsingInts() {
		return (int)(Math.random() * SCORE_MAX_NUM + SCORE_MIN_NUM);
	}
}
