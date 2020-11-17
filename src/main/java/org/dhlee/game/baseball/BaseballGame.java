package org.dhlee.game.baseball;

import java.util.Scanner;

import org.dhlee.game.baseball.constant.BaseballConstant;
import org.dhlee.game.baseball.validation.InputNumberValiator;
import org.dhlee.game.interfaces.Game;
import org.dhlee.game.utils.ConvertUtils;
import org.dhlee.game.utils.PrintUtils;
import org.dhlee.game.utils.generator.RandomNumbersGenerator;

public class BaseballGame implements Game {
	private Scanner scanner;
	private BaseballPlayer defensePlayer;
	private BaseballPlayer attackPlayer;

	public BaseballGame() {
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void init() {
		this.defensePlayer = new BaseballPlayer("Computer");
		this.attackPlayer = new BaseballPlayer("Player");
		setGenerateRandomNumber(this.defensePlayer);
	}

	public void setGenerateRandomNumber(BaseballPlayer baseballPlayer) {
		baseballPlayer.setNumbers(
			RandomNumbersGenerator.generate(BaseballConstant.NUMBER_LIST, BaseballConstant.NUMBER_LENGTH));
	}

	@Override
	public void start() {
		String input = null;
		do {
			PrintUtils.println(BaseballConstant.MESSAGE_ENTER_NUMBERS);
			input = scanner.next();
		} while (!play(input));
	}

	private boolean play(String input) {
		if (InputNumberValiator.checkLengthValidate(input)
			&& InputNumberValiator.checkFormatValidate(input)
			&& InputNumberValiator.checkHasEqualNumberValidate(input)) {
			attackPlayer.setNumbers(ConvertUtils.StringToIntList(input, BaseballConstant.NUMBER_LENGTH));
			PlayResult playResult = defensePlayer.play(attackPlayer.getNumbers());
			PrintUtils.println(playResult.getResultMessage());

			return checkEndGame(playResult);
		}
		return false;
	}

	private boolean checkEndGame(PlayResult playResult) {
		return playResult.getPlayResult(BaseballConstant.NUMBER_LENGTH);
	}

	@Override
	public void stop() {
	}
}
