package baseball.ui.impl;

import baseball.ui.UiSystem;

public class TestUiSystem implements UiSystem {

	// test only
	private String gameInput;
	private String systemInput;
	private String displayData;

	public String getGameInput() {
		return gameInput;
	}

	public void setGameInput(String gameInput) {
		this.gameInput = gameInput;
	}

	public String getSystemInput() {
		return systemInput;
	}

	public void setSystemInput(String systemInput) {
		this.systemInput = systemInput;
	}

	public String getDisplayData() {
		return displayData;
	}

	public void setDisplayData(String displayData) {
		this.displayData = displayData;
	}

	@Override
	public String gameInput() {
		return gameInput;
	}

	@Override
	public String systemInput() {
		return systemInput;
	}

	@Override
	public void display(String data) {
		displayData = data;
	}

	@Override
	public void debug(String data) {

	}

}
