package baseballgame;

import static baseballgame.Validator.*;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseBallGame {
	private final Validator validator;

	private List<String> problemNumbers;
	private List<String> answerNumbers;
	private int strikeCount = 0;
	private int ballCount = 0;
	private boolean isPlaying = false;

	public BaseBallGame(Validator validator) {
		this.validator = validator;
	}

	public void createProblemNumbers() {
		Set<String> numberSet = createNumberSet();
		problemNumbers = Arrays.asList(String.join("", numberSet).split(""));

		if (!validator.validateStringNumbers(problemNumbers)) {
			throw new IllegalStateException("문제 생성에 실패하였습니다. 문제 생성 로직을 확인해주세요.");
		}

		isPlaying = true;
	}

	private Set<String> createNumberSet() {
		Set<String> numbers = new LinkedHashSet<>();

		while (numbers.size() < VALID_NUMBER_LENGTH) {
			int number = drawRandomNumberFrom1to9();
			numbers.add(String.valueOf(number));
		}

		return numbers;
	}

	int drawRandomNumberFrom1to9() {
		Random random = new Random();
		return random.nextInt(9) + 1;
	}

	public void receiveAnswerNumbers() {
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("숫자를 입력해주세요(1~9 중 서로 다른 3자리수) : ");
			answerNumbers = Arrays.asList(scanner.next().split(""));
		} while (!validator.validateStringNumbers(answerNumbers));
	}

	public void countStrikesAndBalls() {
		initCount();
		countStrikes();
		countBalls();

		if (!validator.validateStrikeAndBallCounts(strikeCount, ballCount)) {
			throw new IllegalStateException("스트라이크, 볼 판정에 오류가 발생했습니다. 로직을 확인해주세요.");
		}
	}

	private void initCount() {
		strikeCount = 0;
		ballCount = 0;
	}

	private void countStrikes() {
		for (int i = 0; i < VALID_NUMBER_LENGTH; i++) {
			increaseCountWhenStrike(problemNumbers.get(i), answerNumbers.get(i));
		}
	}

	void increaseCountWhenStrike(String problemNumber, String answerNumber) {
		if (problemNumber.equals(answerNumber)) {
			strikeCount++;
		}
	}

	private void countBalls() {
		for (int i = 0; i < VALID_NUMBER_LENGTH; i++) {
			boolean isStrike = problemNumbers.get(i).equals(answerNumbers.get(i));
			increaseCountWhenBall(problemNumbers, answerNumbers.get(i), isStrike);
		}
	}

	void increaseCountWhenBall(List<String> problemNumbers, String answerNumber, boolean isStrike) {
		if (!isStrike && problemNumbers.contains(answerNumber)) {
			ballCount++;
		}
	}

	public void printCountResults() {
		if (strikeCount != 0) {
			System.out.print(strikeCount + "스트라이크 ");
		}

		if (ballCount != 0) {
			System.out.print(ballCount + "볼");
		}

		System.out.println(strikeCount + ballCount == 0 ? "낫싱" : "");
	}

	public void confirmCorrectAnswer() {
		if (isCorrectAnswer()) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			restartOrEndGame();
		}
	}

	boolean isCorrectAnswer() {
		return strikeCount == 3 && ballCount == 0;
	}

	private void restartOrEndGame() {
		String restartOrEndGameStatus = receiveRestartOrEndGameStatus();
		isPlaying = restartOrEndGameStatus.equals("1");

		if (isPlaying) {
			createProblemNumbers();
		}
	}

	private String receiveRestartOrEndGameStatus() {
		Scanner scanner = new Scanner(System.in);
		String restartOrEndStatus;

		do {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			restartOrEndStatus = scanner.next();
		} while (!validator.validateRestartOrEndStatus(restartOrEndStatus));

		return restartOrEndStatus;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}
}
