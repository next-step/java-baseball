package me.right42.domain;

import me.right42.ui.InputView;

public class Gamer {

	private ThreeBall threeBall;

	public ThreeBall getAnswer(){
		inputValue();
		return this.threeBall;
	}

	private void inputValue(){
		String userInput = InputView.inputNumber();
		this.threeBall = ThreeBall.createThreeBall(userInput);
	}

}
