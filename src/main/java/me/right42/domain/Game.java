package me.right42.domain;

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
		ThreeBall goal = computer.generateBall();

		while(GameStatus.START.equals(gameStatus)) {
			gameStatus = playOneGame(goal);
		}
	}

	private GameStatus playOneGame(ThreeBall goal) {
		ThreeBall answer = gamer.getAnswer();
		BallMatchResult matchResult = ballMatch(answer, goal);

		while(!matchResult.isAllStrike()) {
			answer = gamer.getAnswer();
			matchResult = ballMatch(answer, goal);
		}

		printGameSuccessMessage();
		String code = InputView.inputGameContinue();
		return GameStatus.findByCode(code);
	}

	private BallMatchResult ballMatch(ThreeBall answer, ThreeBall goal) {
		BallMatchResult matchResult = goal.compareTo(answer);
		matchResult.printMatchInfo();
		return matchResult;
	}

	private void printGameSuccessMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}
