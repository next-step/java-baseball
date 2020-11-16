package com.hoomin.game.baseball;

import com.hoomin.game.baseball.domain.Computer;
import com.hoomin.game.baseball.domain.Quiz;
import com.hoomin.game.baseball.view.InputView;

public class BaseBallGame {
	public static final Integer RESTART = 1;
	public static final Integer QUIT = 2;

	public void start() {
		do {
			Computer computer = new Computer();
			Quiz quiz = new Quiz(computer.makeRightAnswer());
			solveQuiz(quiz);
		} while (isOnGoing());
	}

	private void solveQuiz(Quiz quiz) {
		do {
			quiz.checkNumbers(InputView.getNumbers());
		} while (quiz.isUnSolved());
	}

	private boolean isOnGoing() {
		final int input = InputView.getGameOption();
		if (input == RESTART) {
			return true;
		}
		if (input == QUIT) {
			return false;
		}
		throw new IllegalArgumentException("잘못 입력하였습니다.");
	}
}
