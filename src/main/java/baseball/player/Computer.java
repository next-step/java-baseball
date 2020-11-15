package baseball.player;

import baseball.exception.DoNotPermittedException;

public class Computer implements Player {
	private final String number;

	public Computer(String number) {
		this.number = number;
	}

	@Override
	public void setNumber(String input) {
		throw new DoNotPermittedException();
	}

	@Override
	public String getNumber() {
		return number;
	}
}
