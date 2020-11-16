package com.hoomin.game.baseball;

import com.hoomin.game.baseball.domain.Computer;
import com.hoomin.game.baseball.domain.Hints;
import com.hoomin.game.baseball.domain.Quiz;
import com.hoomin.game.baseball.view.InputView;
import com.hoomin.game.baseball.view.OutputView;

public class BaseBallGame {
	public static final Integer RESTART = 1;
	public static final Integer QUIT = 2;

	public void start() {
		do {
			Computer computer = new Computer();
			Quiz quiz = new Quiz(computer.makeRightNumbers());
			solveQuiz(quiz);
		} while (isOnGoing(InputView.getGameOption()));
	}

	private void solveQuiz(Quiz quiz) {
		do {
			final Hints hints = quiz.checkNumbers(InputView.getNumbers());
			OutputView.printHints(hints);
		} while (quiz.isUnSolved());
		OutputView.solveQuiz();
	}

	public boolean isOnGoing(final int input) {
		if (input == RESTART) {
			return true;
		}
		if (input == QUIT) {
			return false;
		}
		throw new IllegalArgumentException("1또는 2를 입력해야 합니다.");
	}
}
