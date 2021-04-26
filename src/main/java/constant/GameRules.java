package constant;

import java.util.function.BiFunction;

import util.GameUtil;

public enum GameRules {
	Strike("스트라이크", GameRules::getStrikeCnt),
	Ball("볼", GameRules::getBallCnt);

	GameRules(String msg, BiFunction<String, String, Integer> apply) {
		this.msg = msg;
		this.apply = apply;
	}

	public String getMsg() {
		return this.msg;
	}

	public BiFunction<String, String, Integer> getApply() {
		return this.apply;
	}

	private final String msg;
	private final BiFunction<String, String, Integer> apply;

	private static int getStrikeCnt(String answer, String userInput) {
		int cnt = 0;
		for (int i = 0; i < GameUtil.LIMIT_DIGIT; i++) {
			cnt += isStrike(answer, userInput, i);
		}
		return cnt;
	}

	private static int isStrike(String answer, String userInput, int idx) {
		return answer.charAt(idx) == userInput.charAt(idx) ? 1 : 0;
	}

	private static int getBallCnt(String answer, String userInput) {
		int cnt = 0;
		for (int i = 0; i < GameUtil.LIMIT_DIGIT; i++) {
			cnt += containSameChar(answer, userInput, i);
		}
		return cnt;
	}

	private static int containSameChar(String answer, String userInput, int idx) {
		int cnt = 0;
		for (int i = 0; i < GameUtil.LIMIT_DIGIT; i++) {
			cnt += isBall(answer, userInput, idx, i);
		}
		return cnt;
	}

	private static int isBall(String answer, String userInput, int idx, int currentIdx) {
		return userInput.charAt(idx) == answer.charAt(currentIdx) && idx != currentIdx ? 1 : 0;
	}
}

