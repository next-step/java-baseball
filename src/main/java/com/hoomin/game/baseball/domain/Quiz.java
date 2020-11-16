package com.hoomin.game.baseball.domain;

public class Quiz {
	private static final int THREE_COUNT = 3;
	private final Numbers rightNumbers;
	private QuizState quizState;

	public Quiz(Numbers rightNumbers) {
		this.rightNumbers = rightNumbers;
		this.quizState = QuizState.UNSOLVED;
	}

	public boolean isUnSolved() {
		return quizState == QuizState.UNSOLVED;
	}

	public Hints checkNumbers(Numbers inputNumbers) {
		final Hints hints = rightNumbers.compareNumbers(inputNumbers);
		if (hints.getStrikeCount() == THREE_COUNT) {
			this.quizState = QuizState.SOLVED;
		}
		return hints;
	}

	enum QuizState {
		SOLVED, UNSOLVED
	}
}
