package baseball.game.playground.referee;

import java.util.ArrayList;
import java.util.List;

/**
 * 심판,
 */
public class Referee {

	// 게임 진행 판단
	private boolean gameOver = false;

	// 다음 플레이 판정
	public boolean nextPlay() {
		return !gameOver;
	}

	// 판정 생성
	public ScoreBoard judgement(String pitcherNumber, String hitterNumber) {

		gameOver = pitcherNumber.equals(hitterNumber);
		String scoreBoard = createScoring(pitcherNumber, hitterNumber);
		return new ScoreBoard(scoreBoard, gameOver);
	}

	/**
	 * 스코어링 판단
	 * @param pitcherNumber pitcher 번호
	 * @param hitterNumber hitter 번호
	 * @return 스코어링 정보를 반환
	 */
	private String createScoring(String pitcherNumber, String hitterNumber) {

		int strikeCount = 0;
		int ballCount = 0;
		for (int i = 0; i < pitcherNumber.length(); ++i) {

			if (pitcherNumber.charAt(i) == hitterNumber.charAt(i)) {
				strikeCount++;
				continue;
			}
			ballCount = calculateBallCount(pitcherNumber, hitterNumber, ballCount, i);
		}
		return decorateScoreBoard(strikeCount, ballCount);
	}

	// ball 갯수를 계산한다
	private int calculateBallCount(String pitcherNum, String hitterNum, int ballCount, int index) {
		for (int j = 0; j < hitterNum.length(); j++) {
			if (hitterNum.charAt(j) == pitcherNum.charAt(index)) {
				ballCount++;
			}
		}
		return ballCount;
	}

	/**
	 * 스코어링을 위한 포멧 생성
	 */
	private void decorateScoreCount(String format, Integer count, List<String> scoringList) {
		if (count == 0) {
			return;
		}
		scoringList.add(String.format(format, count));
	}

	private String decorateScoreBoard(Integer strikeCount, Integer ballCount) {

		if (strikeCount == 0 && ballCount == 0) {
			return "낫싱";
		}

		List<String> scoringList = new ArrayList<>();
		decorateScoreCount("%d 스트라이크", strikeCount, scoringList);
		decorateScoreCount("%d 볼", ballCount, scoringList);
		return String.join(", ", scoringList);
	}

}
