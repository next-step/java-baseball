package me.right42.domain;

import me.right42.ui.InputView;

public class Gamer {

	private BallNumbers threeBall;

	public BallNumbers getAnswer(){
		inputValue();
		return this.threeBall;
	}

	private void inputValue(){
		String userInput = InputView.inputNumber();
		this.threeBall = BallNumbers.create(userInput);
	}

}
