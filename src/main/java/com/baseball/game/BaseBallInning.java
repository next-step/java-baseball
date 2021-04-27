package com.baseball.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.baseball.message.UIMessage;
import com.baseball.rule.Referee;
import com.baseball.rule.Pitcher;
import com.baseball.rule.Player;

public class BaseBallInning {

	private ArrayList<Integer> generatedNumbers;

	boolean strikeout = false;

	public BaseBallInning() { }

	public void onInning() {
		generateBall();
		System.out.println(generatedNumbers); // Debuggin시 확인

		while (!strikeout) {
			ArrayList<Integer> inputNumbers = convertList(inputNumbers());
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

	private ArrayList<Integer> convertList(String inputText) {
		Player player = new Player(inputText);
		player.validateInputText();
		player.convertStringToIntList();

		return player.getInputNumbers();
	}

	private String inputNumbers() {

		System.out.print(UIMessage.TRY_INFO);

		Scanner scanner = new Scanner(System.in);

		return scanner.nextLine();
	}

	private void generateBall() {
		Pitcher pitcher = new Pitcher();
		this.generatedNumbers = (ArrayList<Integer>)pitcher.generateNumber();
	}
}
