package me.right42.service;

import me.right42.domain.BallMatchResult;
import me.right42.domain.BallNumbers;
import me.right42.domain.Computer;
import me.right42.domain.Gamer;
import me.right42.domain.type.GameStatus;
import me.right42.ui.InputView;

public class Game {

	private final Gamer gamer;

	private final Computer computer;

	public Game(Gamer gamer, Computer computer) {
		this.gamer = gamer;
		this.computer = computer;
	}

	public void start() {
		GameStatus gameStatus = GameStatus.START;
		BallNumbers goal = computer.getQuestion();

		while(GameStatus.START.equals(gameStatus)) {
			gameStatus = playOneGame(goal);
			goal = computer.getQuestion();
		}
	}

	private GameStatus playOneGame(BallNumbers goal) {
		BallNumbers answer = gamer.getAnswer();
		BallMatchResult matchResult = ballMatch(answer, goal);

		while(!matchResult.isGameComplete()) {
			answer = gamer.getAnswer();
			matchResult = ballMatch(answer, goal);
		}

		printGameSuccessMessage();
		String code = InputView.inputGameContinue();
		return GameStatus.findByCode(code);
	}

	private BallMatchResult ballMatch(BallNumbers answer, BallNumbers goal) {
		BallMatchResult matchResult = goal.compareTo(answer);
		matchResult.printMatchInfo();
		return matchResult;
	}

	private void printGameSuccessMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
