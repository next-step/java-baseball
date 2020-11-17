package service;

import vo.GameNumber;
import vo.GameResult;

public class Game {
	private static View view = new View();
	private static Baseball baseball = new Baseball();

	public void execution() {
		GameResult gameResult;
		GameNumber comNumber = baseball.createRandomGameNumber();
		view.output("야구게임 시작!! 중복되지 않은 3자리 숫자를 입력하세요.");
		do {
			view.output("hint: " + comNumber.toString()); // 원활한 테스트를 위한 힌트!
			gameResult = baseball.getGameResult(comNumber,
				baseball.convertNumberStringToGameNumber(view.viewUserNumberInput()));
			view.viewGameResultOutput(gameResult);
		} while (!gameResult.isGameSuccess());
		view.output("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public void repeatExecution() {
		do {
			execution();
			view.output("게임을 계속 하시려면 아무키나 입력하세요. 종료하시려면 Q를 입력하세요.");
		} while (!"Q".equalsIgnoreCase(view.input()));
		view.output("Good Bye~!!");
	}
}
