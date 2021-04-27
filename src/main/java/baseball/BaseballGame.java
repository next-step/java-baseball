package baseball;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import baseball.domain.GameStatus;
import baseball.domain.InputStatus;
import baseball.utils.Question;

/**
 * @author forrest-k
 */
public class BaseballGame {

	private String status;
	private Map<String, Integer> rightAnswer;
	private final Scanner scanner;
	private int strikeCount;
	private int ballCount;

	public BaseballGame() {
		this.scanner = new Scanner(System.in);
		Question question = new Question();
		this.rightAnswer = question.getValues();
		this.status =  GameStatus.START.name();
		System.out.println(rightAnswer);
	}

	public void run() {
		int setIndex = 1;
		for(String s: playGames()) {
			checkInputValueByInputStatus(setIndex, rightAnswer.get(s));
			setIndex ++;
		}

		System.out.println(resultText());
		chooseNextStepByStatus();
	}

	public Set<String> playGames() {
		strikeCount = 0;
		ballCount = 0;
		System.out.println("숫자를 입력해 주세요: ");
		Set<String> inputSet;
		try {
			inputSet = convertInputValuesStringToSet(scanner.nextInt() + "");

			if(inputSet.size() < 3) {
				System.out.println(InputStatus.valueOf("INVALIDATE").getStatus());
				return playGames();
			}

			return inputSet;
		} catch (InputMismatchException e) {
			scanner.next();
			System.out.println(InputStatus.valueOf("INVALIDATE").getStatus());
			return playGames();
		}
	}

	public void checkInputValueByInputStatus(int inputIndex, Integer rightAnswerIndex) {
		if(rightAnswerIndex == null) {
			return;
		}

		if (inputIndex == rightAnswerIndex) {
			this.strikeCount++;
		} else {
			this.ballCount++;
		}
	}

	/** 입력 값 유효성 체크 */
	public Set<String> convertInputValuesStringToSet(String inputValues) {
		return new LinkedHashSet<>(Arrays.asList(inputValues.split("")));
	}

	/** 게임 진행 상황에 따른 다음 단계 선택 */
	public String resultText () {

		String resultText = "";
		if(strikeCount > 0) {
			resultText += strikeCount + " " +InputStatus.STRIKE.getStatus();
		}

		if(ballCount > 0) {
			resultText += " " +ballCount + InputStatus.BALL.getStatus();
		}

		if("".equals(resultText)) {
			resultText = InputStatus.NOTHING.getStatus();
		}

		return resultText;
	}

	/** 게임 진행 상황에 따른 다음 단계 선택 */
	public void chooseNextStepByStatus () {
		if(this.strikeCount == 3) {
			notifyFinishGameAndAskNext();
		} else {
			run();
		}
	}

	public void notifyFinishGameAndAskNext() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		try {
			if(scanner.nextInt() == 1) {
				BaseballGame baseballGame = new BaseballGame();
				baseballGame.run();
			}

		} catch (InputMismatchException e) {
			//scanner.next();
			System.out.println("게임이 종료되었습니다.");
		}
	}
}
