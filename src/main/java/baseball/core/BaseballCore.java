package baseball.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.code.ScoreCode;

public class BaseballCore {

	private boolean isEndGame = true;
	private Set<Character> numbersForReset = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
	private List<Character> numbersForGame = new ArrayList<>();

	/**
	 * 컴퓨터가 게임을 생성한다.
	 */
	private void makeGame() {
		this.isEndGame = false; //게임 진행 상태로 변경

		// 임의의 값 생성
		List<Character> tempNumberList = new ArrayList<>();
		tempNumberList.addAll(this.numbersForReset);
		Collections.shuffle(tempNumberList);

		// 게임 초기화
		this.numbersForGame.clear();
		this.numbersForGame.addAll(tempNumberList.subList(0, 3));
	}

	/**
	 * 사용자가 입력한 문자열에서 볼의 갯수를 계산한다.
	 * - 스트라이크 여부는 계산하지 않는다.
	 * - 최종 스코어 계산시 최종 볼의 갯수를 계산한다.
	 * @param playerInput
	 * @return int
	 */
	private int countBall(String playerInput) {
		int ball = 0;
		for (int i = 0; i < playerInput.split("").length; i++) {
			ball = (numbersForGame.contains(playerInput.charAt(i))) ? ++ball : ball;
		}
		return ball;
	}

	/**
	 * 사용자가 입력한 문자열에서 스트라이크의 갯수를 계산한다.
	 * @param playerInput
	 * @return int
	 */
	private int countStrike(String playerInput) {
		int strike = 0;
		for (int i = 0; i < playerInput.split("").length; i++) {
			strike = (playerInput.charAt(i) == numbersForGame.get(i)) ? ++strike : strike;
		}
		return strike;
	}

	/**
	 * 최종 스코어를 계산한다.
	 * - 볼은 스트라이크의 필요조건. 즉, 볼은 스트라이크보다 크거나 같다.
	 * - 볼과 스트라이크의 개수가 같으면 : 볼 0
	 * - 볼이 스트라이크보다 많은 경우 : (볼 카운트) - (스트라이크 카운트) = 최종 볼 개수
	 * - 둘 다 0인 경우 : 낫싱
	 * @param playerInput
	 * @return ScoreCode
	 */
	private ScoreCode finalScore(String playerInput) {

		int strike = this.countStrike(playerInput);
		int ball = this.countBall(playerInput) - strike;

		ScoreCode scoreCode = ScoreCode.getScoreCode(strike, ball);
		ScoreCode.printScore(scoreCode);
		return scoreCode;
	}

	/**
	 * 게임을 초기화한다.
	 * - 게임이 새로 시작하는 경우에만 게임을 초기화한다.
	 */
	public void resetGameWhenNewGame() {
		if (this.isEndGame) {
			this.makeGame();
		}
	}
}
