package com.hoomin.game.baseball;

import java.util.function.Function;

import com.hoomin.game.baseball.domain.Computer;
import com.hoomin.game.baseball.domain.Hints;
import com.hoomin.game.baseball.domain.Quiz;
import com.hoomin.game.baseball.view.InputView;
import com.hoomin.game.baseball.view.OutputView;

/**
 * 퀴즈와 컴퓨터를 생성하는 주체
 * InputView 와 OutputView 호출
 */
public class BaseBallGame {

	public void start() {
		do {
			Computer computer = new Computer();
			Quiz quiz = new Quiz(computer.makeRightNumbers());
			solveQuiz(quiz);
		} while (InputView.getGameOption().isOnGoing());
	}

	private void solveQuiz(Quiz quiz) {
		do {
			final Hints hints = quiz.checkNumbers(InputView.getNumbers());
			OutputView.printHints(hints);
		} while (quiz.isUnSolved());
		OutputView.solveQuiz();
	}
}
