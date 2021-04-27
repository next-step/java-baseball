package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JavaBaseBallGame {
	
	public static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.";

	public int numberIndex;
	public boolean wrong = true;
	public boolean startGameAgain;
	public List<Integer> answerNumber;
	public JavaBaseBallCount gameCount;
	public JavaBaseBallUserNumber userNumber;

	/**
	 * 게임을 시작한다.
	 */
	public void startGame() {
		gameCount = new JavaBaseBallCount();
		setAnswerNumber();
		gameProcess();

		if (startGameAgain) {
			wrong = true;
			startGameAgain = false;
			startGame();
		}
	}

	/**
	 * 정답이될 서로 다른 숫자 3개를 정한다.
	 */
	public void setAnswerNumber() {
		List<Integer> numberList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		Collections.shuffle(numberList);
		this.answerNumber = numberList.subList(0, 3);
	}

	/**
	 * 플레이어로 부터 숫자를 입력받아 게임을 진행하는 과정을 반복한다.
	 */
	public void gameProcess() {
		userNumber = new JavaBaseBallUserNumber();

		while (wrong) {
			userNumber.setUserNumber();
			countUserNumber();
			printHintText();
			gameCount.resetCount();
		}
	}

	/**
	 * 사용자가 입력한 숫자에서 strike와 ball숫자를 센다.
	 * @param userNumber
	 */
	public void countUserNumber() {
		numberIndex = 0;
		userNumber.userNumber.forEach(number -> {
			gameCount.strikeCount += answerNumber.contains(number) && answerNumber.get(numberIndex) == number ? 1 : 0;
			gameCount.ballCount += answerNumber.contains(number) && answerNumber.get(numberIndex) != number ? 1 : 0;
			numberIndex++;
		});
	}

	/**
	 * 플레이어에게 힌트를 제공한다.
	 */
	public void printHintText() {
		if(userNumber.numberIsError) {
			String resultMessage = gameCount.makeResultMessage();
			resultMessage = gameCount.strikeCount == 3 ? CORRECT_MESSAGE : resultMessage;
			System.out.println(resultMessage);
		}

		if (gameCount.strikeCount == 3) {
			endOrStartGameAgain();
		}
	}

	/**
	 * 플레이어에게 게임을 다시 시작할지 종료할지 묻는다.
	 */
	public void endOrStartGameAgain() {
		wrong = gameCount.strikeCount == 3 ? false : true;
		Scanner scan = new Scanner(System.in);
		String text = scan.next();

		if (text.equals("1")) {
			startGameAgain = true;
		}
	}
}