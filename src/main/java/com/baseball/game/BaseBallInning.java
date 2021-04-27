package com.baseball.game;

import java.util.ArrayList;

import com.baseball.rule.Referee;
import com.baseball.rule.Pitcher;
import com.baseball.rule.Player;

public class BaseBallInning {

	private ArrayList<Integer> generatedNumbers;

	boolean strikeout = false;

	public BaseBallInning() {
	}

	public void onInning() {
		generateBall();
		System.out.println(generatedNumbers); // Debuggin시 확인

		while (!strikeout) {
			ArrayList<Integer> inputNumbers = convertList();
			decideBall(inputNumbers);
		}
	}

	private Referee decideBall(ArrayList<Integer> inputNumbers) {
		Referee referee = new Referee(generatedNumbers, inputNumbers);
		referee.compareNumbers();

		System.out.println(referee.getResultMessage());

		if (referee.isStrikeOut()) {
			strikeout = true;
		}

		return referee;
	}

	private ArrayList<Integer> convertList() {
		Player player = new Player();
		player.setValidatedText();
		player.convertStringToIntList();

		return player.getValidatedNumbers();
	}

	private void generateBall() {
		Pitcher pitcher = new Pitcher();
		this.generatedNumbers = (ArrayList<Integer>)pitcher.generateNumber();
	}
}
