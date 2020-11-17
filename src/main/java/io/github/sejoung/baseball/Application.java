package io.github.sejoung.baseball;

import java.util.Scanner;

import io.github.sejoung.baseball.domain.BaseBallGameUI;

public class Application {
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
		BaseBallGameUI baseBallGameUI = new BaseBallGameUI(scanner);
		baseBallGameUI.playGame();
	}
}
