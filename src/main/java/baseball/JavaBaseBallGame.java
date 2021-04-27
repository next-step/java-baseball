package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JavaBaseBallGame {
	
	public static final String CORRECT_MESSAGE = "3���� ���ڸ� ��� �����̽��ϴ�! ��������\n������ ���� �����Ϸ���1, �����Ϸ��� 2�� �Է��ϼ���.";

	public int numberIndex;
	public boolean wrong = true;
	public boolean startGameAgain;
	public List<Integer> answerNumber;
	public JavaBaseBallCount gameCount;
	public JavaBaseBallUserNumber userNumber;

	/**
	 * ������ �����Ѵ�.
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
	 * �����̵� ���� �ٸ� ���� 3���� ���Ѵ�.
	 */
	public void setAnswerNumber() {
		List<Integer> numberList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		Collections.shuffle(numberList);
		this.answerNumber = numberList.subList(0, 3);
	}

	/**
	 * �÷��̾�� ���� ���ڸ� �Է¹޾� ������ �����ϴ� ������ �ݺ��Ѵ�.
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
	 * ����ڰ� �Է��� ���ڿ��� strike�� ball���ڸ� ����.
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
	 * �÷��̾�� ��Ʈ�� �����Ѵ�.
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
	 * �÷��̾�� ������ �ٽ� �������� �������� ���´�.
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