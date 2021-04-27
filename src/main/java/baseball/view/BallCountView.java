package baseball.view;

import baseball.config.AppConfig;
import baseball.domain.BallCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BallCountView {
	private final int RANDOM_NUMBER_LENGTH;
	private final int MAX_RANDOM_NUMBER;
	private final int MIN_RANDOM_NUMBER;
	private final String LINE_SEPARATOR = System.lineSeparator();
	private final Scanner scanner;

	public BallCountView(AppConfig appConfig, Scanner scanner) {
		this.RANDOM_NUMBER_LENGTH = appConfig.getRandomNumberLength();
		this.MAX_RANDOM_NUMBER = appConfig.getMaxRandomNumber();
		this.MIN_RANDOM_NUMBER = appConfig.getMinRandomNumber();
		this.scanner = scanner;
	}

	public String requestRandomNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		return scanner.nextLine();
	}

	public void responseBallCount(BallCount ballCount) {
		List<String> list = new ArrayList<>();
		addBallCountMessage(list, ballCount.getStrike(), "%d스트라이크");
		addBallCountMessage(list, ballCount.getBall(), "d볼");
		if (isNothingAndPrintMessage(list)) {
			return;
		}
		printBallCountMessage(list);
		printAllMatchMessage(ballCount.getStrike());
	}

	public void responseNonNumericCharacters() {
		System.out.printf("%d~%d 사이의 %d자리 중복되지 않는 숫자를 입력해주세요.%s", MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER, RANDOM_NUMBER_LENGTH, LINE_SEPARATOR);
	}

	public void responseDuplicateCharacters() {
		System.out.println("중복된 숫자가 존재합니다.");
	}

	private void addBallCountMessage(List<String> list, int value, String format) {
		if (value > 0) {
			list.add(String.format(format, value));
		}
	}

	private boolean isNothingAndPrintMessage(List<String> list) {
		boolean nothing = list.size() == 0;
		if (nothing) {
			System.out.println("낫싱");
		}
		return nothing;
	}

	private void printBallCountMessage(List<String> list) {
		System.out.println(String.join(" ", list));
	}

	private void printAllMatchMessage(int strike) {
		if (RANDOM_NUMBER_LENGTH == strike) {
			System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임종료%s", RANDOM_NUMBER_LENGTH, LINE_SEPARATOR);
		}
	}
}
