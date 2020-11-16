package com.nextstep.example;

import com.nextstep.example.model.Hitter;
import com.nextstep.example.model.Pitcher;
import com.nextstep.example.model.Referee;

import java.util.Scanner;

public class BaseBallGame {
	private Scanner sc;

	public BaseBallGame(Scanner sc) {
		this.sc = sc;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BaseBallGame game = new BaseBallGame(sc);
		Hitter computer = new Hitter();
		Pitcher player = new Pitcher(sc);

		do {
			computer.predictPitching();
			game.play(computer, player);
		} while (game.isContinue());
	}

	private void play(Hitter computer, Pitcher player) {
		Referee referee = new Referee();
		String balls;
		do {
			balls = player.pitch();
		} while (!referee.getJudge(computer.getPitchPrediction(), balls));
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
	}

	private boolean isContinue() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String input = sc.nextLine();
		if (!"1".equals(input) && !"2".equals(input)) {
			throw new IllegalArgumentException("유효하지 않은 입력 값입니다.");
		}
		return "1".equals(input);
	}
}
