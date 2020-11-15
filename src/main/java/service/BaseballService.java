package service;

public class BaseballService {
	public boolean playUntilEnd(String inputScore) {
		if (!isValidInputScore(inputScore)) {
			return false;
		}

		return true;
	}

	public boolean isValidInputScore(String inputScore) {
		return inputScore.trim().length() == 3;
	}
}
