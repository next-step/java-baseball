package com.hoomin.game.baseball.view;

import com.hoomin.game.baseball.domain.Hints;

/**
 * 출력과 관련된 비즈니스 로직을 담당한다.
 */
public class OutputView {
	public static void printHints(Hints hints) {
		final Integer strikeCount = hints.getStrikeCount();
		final Integer ballCount = hints.getBallCount();
		if (strikeCount.equals(0) && ballCount.equals(0)) {
			System.out.println("낫싱");
		}
		System.out.println(getStringBuilder(strikeCount, ballCount));
	}

	private static String getStringBuilder(Integer strikeCount, Integer ballCount) {
		StringBuilder builder = new StringBuilder();
		getHintMessage(builder, strikeCount, " 스트라이크 ");
		getHintMessage(builder, ballCount, " 볼");
		return builder.toString().trim();
	}

	private static void getHintMessage(StringBuilder builder, Integer count, String message) {
		if (count > 0) {
			builder.append(count).append(message);
		}
	}

	public static void solveQuiz() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
	}
}
