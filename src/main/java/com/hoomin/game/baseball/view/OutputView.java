package com.hoomin.game.baseball.view;

import com.hoomin.game.baseball.domain.Hints;

/**
 * 비즈니스 로직 없이 출력을 담당한다.
 */
public class OutputView {
	public static void printHints(Hints hints) {
		System.out.println(hints);
	}

	public static void solveQuiz() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
	}
}
