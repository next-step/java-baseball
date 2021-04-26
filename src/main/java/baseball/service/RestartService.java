package baseball.service;

import baseball.error.NonRestartCharactersException;

public class RestartService {

	private final String RESTART = "1";
	private final String EXIT = "2";

	public boolean isRestart(String input) {
		if (!input.matches(String.format("^[%s|%s]{1}$", RESTART, EXIT))) {
			throw new NonRestartCharactersException();
		}
		return RESTART.equals(input);
	}

}
