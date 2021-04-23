/*
 * @(#) BeasBallGame.java 2021. 04. 23.
 *
 */
package com.tistory.ddoriya;

import com.tistory.ddoriya.constants.GameRule;
import com.tistory.ddoriya.constants.GameType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 이상준
 */
public class BaseBallGameService {
	private List<Integer> computerNumbers;
	private Random random = new Random();
	private int strikeCount;
	private int ballCount;

	public BaseBallGameService() {
		this.computerNumbers = getComputerNumbers();
	}

	public void executeGame(String input) {
		if (!BaseBallGameValidator.isUserNumberValid(input)) {
			throw new NumberFormatException("입력값 형식이 다릅니다.");
		}

		initStatus();
		turn(input);
	}

	public boolean isGameCompleted() {
		return strikeCount == GameRule.MAX_STRIKE_COUNT;
	}

	public String getGameMessage() {
		String strikeMessage = strikeCount > 0 ? String.format("%d %s", strikeCount, GameType.STRIKE.getType()) : "";
		String ballMessage = ballCount > 0 ? String.format("%d %s", ballCount, GameType.BALL.getType()) : "";

		return strikeCount + ballCount > 0 ? String.format("%s%s", strikeMessage, ballMessage) : GameType.NOTHING.getType();
	}

	private void turn(String input) {
		for (int i = 0; i < input.length(); i++) {
			int number = input.charAt(i) - '0';
			if (computerNumbers.get(i) == number) {
				strikeCount++;
			} else if (computerNumbers.contains(number)) {
				ballCount++;
			}
		}
	}

	private List<Integer> getComputerNumbers() {
		List<Integer> computerNumbers = new ArrayList<>();

		while (computerNumbers.size() < GameRule.MAX_SIZE) {
			int randomNumber = getRandomNumber();
			if (!computerNumbers.contains(randomNumber)) {
				computerNumbers.add(randomNumber);
			}
		}

		return computerNumbers;
	}

	private void initStatus() {
		strikeCount = 0;
		ballCount = 0;
	}

	private int getRandomNumber() {
		return random.nextInt(GameRule.MAX_NUMBER) + 1;
	}
}
