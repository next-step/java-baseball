package baseball.ui.impl;

import baseball.ui.UiSystem;

public class TestUiSystem implements UiSystem {

	// test only
	private Integer gameInput;
	private String systemInput;

	public void setGameInput(Integer gameInput) {
		this.gameInput = gameInput;
	}

	public void setSystemInput(String systemInput) {
		this.systemInput = systemInput;
	}

	@Override
	public Integer gameInput() {
		return gameInput;
	}

	@Override
	public String systemInput() {
		return systemInput;
	}

	@Override
	public void display(String data) {

	}

}
