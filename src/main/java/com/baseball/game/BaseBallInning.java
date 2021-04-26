package com.baseball.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.baseball.message.UIMessage;
import com.baseball.rule.BallComparator;
import com.baseball.rule.BallPlayer;
import com.baseball.rule.BallGenerator;

public class BaseBallInning {

	boolean strikeout = false;

	public BaseBallInning() {}

	public void startInning() {
		// 3자리 숫자 생성
		BallGenerator ballGenerator = new BallGenerator();
		ArrayList<Integer> generatedNumbers = (ArrayList<Integer>)ballGenerator.generateNumber();
		System.out.println(generatedNumbers);

		while (!strikeout) {
			// infoMessage
			System.out.print(UIMessage.TRY_INFO);

			Scanner scanner = new Scanner(System.in);
			String inputText = scanner.nextLine();

			// 입력값 유효성 검증
			BallPlayer ballPlayer = new BallPlayer(inputText);
			ArrayList<Integer> inputNumbers = ballPlayer.getInputNumbers();

			// strike,ball 판단
			BallComparator ballComparator = new BallComparator(generatedNumbers, inputNumbers);
			ballComparator.compareNumbers();
			System.out.println(ballComparator.getResultMessage());

			//FIX 정답 여부 확인
			if (ballComparator.isStrikeOut()) {
				strikeout = true;
			}
		}
	}
}
