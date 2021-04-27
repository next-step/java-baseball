package baseball.view;

import baseball.config.AppConfig;
import baseball.domain.BallCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BallCountView {

	private final int RANDOM_NUMBER_LENGTH;
	private final String LINE_SEPARATOR = System.lineSeparator();
	private final Scanner scanner;

	public BallCountView(AppConfig appConfig, Scanner scanner) {
		this.RANDOM_NUMBER_LENGTH = appConfig.getRandomNumberLength();
		this.scanner = scanner;
	}

	public String requestRandomNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		return scanner.nextLine();
	}

	public void responseBallCount(BallCount ballCount) {
		List<String> message = new ArrayList<>();
		if (ballCount.getStrike() > 0) {
			message.add(String.format("%d스트라이크", ballCount.getStrike()));
		}
		if (ballCount.getBall() > 0) {
			message.add(String.format("%d볼", ballCount.getBall()));
		}
		System.out.println(message.size() == 0 ? "낫싱" : String.join(" ", message));
	}

}
