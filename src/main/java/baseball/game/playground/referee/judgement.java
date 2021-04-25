package baseball.game.playground.referee;

import java.util.ArrayList;
import java.util.List;

import baseball.ui.UiSystem;

/**
 * pitcher와 hitter의 판정 정보를 생성한다
 * 생성된 판정 정보를 통해 게임 종료 및 화면 표시를 할 수 있다
 */
public class judgement {

	private boolean gameOver = false;
	private final String scoring;

	public judgement(String pitcherNumber, String hitterNumber) {

		int strikeCount = 0;
		int ballCount = 0;
		for (int i = 0; i < pitcherNumber.length(); ++i) {

			if (pitcherNumber.charAt(i) == hitterNumber.charAt(i)) {
				strikeCount++;
				continue;
			}

			ballCount = calculateBallCount(pitcherNumber, hitterNumber, ballCount, i);
		}

		this.scoring = createScoring(strikeCount, ballCount);
		this.gameOver = pitcherNumber.equals(hitterNumber);

	}

	public boolean isGameOver() {
		return gameOver;
	}

	// ball 갯수를 계산한다
	private int calculateBallCount(String pitcherNum, String hitterNum, int ballCount, int i) {
		for (int j = 0; j < hitterNum.length(); j++) {
			if (hitterNum.charAt(j) == pitcherNum.charAt(i)) {
				ballCount++;
			}
		}
		return ballCount;
	}

	// 스코어링 정보를 표시하기 위한 정보를 생성한다
	private String createScoring(Integer strikeCount, Integer ballCount) {
		if (strikeCount == 0 && ballCount == 0) {
			return "낫싱";
		}

		List<String> scoringList = new ArrayList<>();
		decorateScoreCount("%d 스트라이크", strikeCount, scoringList);
		decorateScoreCount("%d 볼", ballCount, scoringList);
		return String.join(", ", scoringList);
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

	// UI 시스템에 스코어링 결과를 출력한다
	public void display(UiSystem uiSystem) {

		uiSystem.display("Referee");
		uiSystem.display(scoring);
	}
}
