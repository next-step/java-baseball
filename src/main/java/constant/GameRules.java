package constant;

import java.util.function.BiPredicate;
import java.util.function.Function;

import util.GameUtil;

public enum GameRules {
	Success(GameRules::getSuccessMsg, (strikeCnt, ballCnt) -> strikeCnt == GameUtil.LIMIT_DIGIT),
	Strike(GameRules::getStrikeMsg, (strikeCnt, ballCnt) -> strikeCnt > 0),
	Ball(GameRules::getBallMsg, (strikeCnt, ballCnt) -> ballCnt > 0),
	Nothing(GameRules::getNothingMsg, (strikeCnt, ballCnt) -> strikeCnt < 1 && ballCnt < 1);

	GameRules(Function<Integer, String> msg, BiPredicate<Integer, Integer> check) {
		this.msg = msg;
		this.check = check;
	}

	private final Function<Integer, String> msg;
	private final BiPredicate<Integer, Integer> check;

	public Function<Integer, String> getMsg() {
		return this.msg;
	}

	public BiPredicate<Integer, Integer> getCheck() {
		return this.check;
	}

	private static String getSuccessMsg(Integer strikeCnt) {
		return String.format("%s\n%d개의 숫자를 모두 맞히셨습니다! 게임 종료", getStrikeMsg(strikeCnt).trim(), strikeCnt);
	}

	private static String getStrikeMsg(Integer strikeCnt) {
		return String.format("%d 스트라이크 ", strikeCnt);
	}

	private static String getBallMsg(Integer ballCnt) {
		return String.format("%d 볼 ", ballCnt);
	}

	private static String getNothingMsg(Integer strikeCnt) {
		return "낫싱";
	}

	public static int getStrikeCnt(String answer, String userInput) {
		int cnt = 0;
		for (int i = 0; i < GameUtil.LIMIT_DIGIT; i++) {
			cnt += isStrike(answer, userInput, i);
		}
		return cnt;
	}

	private static int isStrike(String answer, String userInput, int idx) {
		return answer.charAt(idx) == userInput.charAt(idx) ? 1 : 0;
	}

	public static int getBallCnt(String answer, String userInput) {
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

