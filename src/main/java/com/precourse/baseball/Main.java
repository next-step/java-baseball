package com.precourse.baseball;

public class Main {
	public static void main(String[] args) {
		Playground playground = new Playground();
		do {
			playground.play();
		} while (playground.menuNumber == 1);
	}
}
