package com.baseball.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.baseball.message.UIMessage;
import com.baseball.rule.BallComparator;
import com.baseball.rule.BallGenerator;
import com.baseball.rule.BallPlayer;

public class BaseBallInning {

	private ArrayList<Integer> generatedNumbers;

	boolean strikeout = false;

	public BaseBallInning() {
	}

	public void onInning() {
		// 3자리 숫자 생성
		generateBall();
		System.out.println(generatedNumbers); // Debuggin시 확인

		while (!strikeout) {
			// 입력값 받기( 유효성 검증 포함 )
			ArrayList<Integer> inputNumbers = convertList(inputNumbers());

			// 정답 여부 확인
			decideBall(inputNumbers);
		}
	}

	private BallComparator decideBall(ArrayList<Integer> inputNumbers) {
		BallComparator ballComparator = new BallComparator(generatedNumbers, inputNumbers);
		ballComparator.compareNumbers();

		System.out.println(ballComparator.getResultMessage());

		if (ballComparator.isStrikeOut()) {
			strikeout = true;
		}

		return ballComparator;
	}

	private ArrayList<Integer> convertList(String inputText) {
		BallPlayer ballPlayer = new BallPlayer(inputText);
		ballPlayer.validateInputText();
		ballPlayer.convertStringToIntList();

		return ballPlayer.getInputNumbers();
	}

	private String inputNumbers() {

		System.out.print(UIMessage.TRY_INFO);

		Scanner scanner = new Scanner(System.in);

		return scanner.nextLine();
	}

	private void generateBall() {
		BallGenerator ballGenerator = new BallGenerator();
		this.generatedNumbers = (ArrayList<Integer>)ballGenerator.generateNumber();
	}
}
