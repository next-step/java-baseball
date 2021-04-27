package baseball.view;

import baseball.config.AppConfig;

import java.util.Scanner;

public class RestartView {

	private final int RANDOM_NUMBER_LENGTH;
	private final String RESTART_COMMAND;
	private final String EXIT_COMMAND;
	private final String LINE_SEPARATOR = System.lineSeparator();
	private final Scanner scanner;

	public RestartView(AppConfig appConfig, Scanner scanner) {
		this.RANDOM_NUMBER_LENGTH = appConfig.getRandomNumberLength();
		this.RESTART_COMMAND = appConfig.getRestartCommand();
		this.EXIT_COMMAND = appConfig.getExitCommand();
		this.scanner = scanner;
	}

	public String requestRestartCommand() {
		System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임종료%s" +
						"게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.%s",
				RANDOM_NUMBER_LENGTH, LINE_SEPARATOR,
				RESTART_COMMAND, EXIT_COMMAND, LINE_SEPARATOR);
		return scanner.nextLine();
	}

}