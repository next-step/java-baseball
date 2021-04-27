package baseball.service;

import baseball.config.AppConfig;
import baseball.error.NonRestartCharactersException;

public class RestartService {
	private final String RESTART_COMMAND;
	private final String EXIT_COMMAND;

	public RestartService(AppConfig appConfig) {
		this.RESTART_COMMAND = appConfig.getRestartCommand();
		this.EXIT_COMMAND = appConfig.getExitCommand();
	}

	public boolean isRestart(String input) {
		if (!input.matches(String.format("^[%s|%s]{1}$", RESTART_COMMAND, EXIT_COMMAND))) {
			throw new NonRestartCharactersException();
		}
		return RESTART_COMMAND.equals(input);
	}
}
