package model;

import util.CustomException;

import java.util.*;

public class Gamer {
	private ArrayList<String> userInputNumbers = new ArrayList<>();
	private Baseball baseball;
	private int strike = 0;
	private int ball = 0;

	public Gamer(Baseball baseball) {
		this.baseball = baseball;
	}

	private void setUserInputNumbers(ArrayList<String> userInputNumbers) {
		this.userInputNumbers = userInputNumbers;
	}

	private void setStrike(int strike) {
		this.strike = strike;
	}

	private void setBall(int ball) {
		this.ball = ball;
	}

	private void checkInputNumber(String input, int size) throws
			CustomException.InvalidNumberFormatException,
			CustomException.InvalidNumberOfRangeException,
			CustomException.InvalidNumberOfSizeException {
		LinkedHashSet<String> linkedHashSet = checkDuplicateNumber(input);
		validNumberSize(linkedHashSet, size);
		setUserInputNumbers(convertStringToArray(input));
	}

	private LinkedHashSet<String> checkDuplicateNumber(String input) throws
			CustomException.InvalidNumberFormatException,
			CustomException.InvalidNumberOfRangeException {
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		for (char number : input.toCharArray()) {
			int convertNumberFromChar = parseIntOrThrow(number);
			linkedHashSet.add(String.valueOf(validNumberRange(convertNumberFromChar, 1, 9)));
		}

		return linkedHashSet;
	}

	private int parseIntOrThrow(char number) throws
			CustomException.InvalidNumberFormatException {
		OptionalInt optional = OptionalInt.of(Integer.parseInt(String.valueOf(number)));
		return optional.orElseThrow(() ->
				new CustomException.InvalidNumberFormatException("잘못된 형식입니다. 숫자만 입력해주세요."));
	}

	private int validNumberRange(int number, int start, int end) throws
			CustomException.InvalidNumberOfRangeException {
		if (number < start || number > end) {
			throw new CustomException.InvalidNumberOfRangeException("숫자는 1 ~ 9사이로 입력해주세요");
		}

		return number;
	}

	private void validNumberSize(LinkedHashSet<String> linkedHashSet, int size) throws
			CustomException.InvalidNumberOfSizeException {
		if (linkedHashSet.size() != size) {
			throw new CustomException.InvalidNumberOfSizeException("중복되지 않은 숫자로 " + size + "개를 입력해주세요.");
		}
	}

	private ArrayList<String> convertStringToArray(String input) {
		ArrayList<String> convertArray = new ArrayList<>();
		for (char number : input.toCharArray()) {
			convertArray.add(String.valueOf(number));
		}

		return convertArray;
	}

	private String inputUserNumbers() {
		System.out.println("숫자를 입력해주세요 : ");
		return getInputNumber();
	}

	public void playGame() {
		String inputNumbers = inputUserNumbers();

		try {
			checkInputNumber(inputNumbers, 3);
			showGameResult();
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다.");
			playGame();
		}
	}

	private void showGameResult() throws
			CustomException.InvalidNumberFormatException,
			CustomException.InvalidNumberOfSizeException,
			CustomException.InvalidNumberOfRangeException {
		setStrike(isStrike(baseball.getDefaultNumbers()));
		setBall(isBall(baseball.getDefaultNumbers()));
		printGameResult();
		checkGameResult();
	}

	private void retryGame() {
		this.baseball.setDefaultNumbers();
		setUserInputNumbers(new ArrayList<>());
		playGame();
	}

	private void doneGame() throws
			CustomException.InvalidNumberFormatException,
			CustomException.InvalidNumberOfSizeException,
			CustomException.InvalidNumberOfRangeException {
		System.out.println(GameResultEnum.DONE.getValue());
		System.out.println(GameResultEnum.RETRY.getValue());
		checkRetry(getInputNumber());
	}

	private void checkRetry(String input) throws
			CustomException.InvalidNumberFormatException,
			CustomException.InvalidNumberOfSizeException,
			CustomException.InvalidNumberOfRangeException {
		checkInputNumber(input, 1);
		int inputNumber = validNumberRange(parseIntOrThrow(input.charAt(0)), 1, 2);

		if (inputNumber == 2) {
			return;
		}

		retryGame();
	}

	private String getInputNumber() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	private void checkGameResult() throws
			CustomException.InvalidNumberFormatException,
			CustomException.InvalidNumberOfSizeException,
			CustomException.InvalidNumberOfRangeException {
		if (strike == 3) {
			doneGame();
			return;
		}

		playGame();
	}

	private void printGameResult() {
		String result = "" +
				GameResultEnum.STRIKE.getMessage(strike) +
				" " +
				GameResultEnum.BALL.getMessage(ball);
		if (result.equals("")) {
			result = GameResultEnum.NOTHING.name();
		}

		System.out.println(result);
	}

	private int isStrike(ArrayList<String> defaultNumbers) {
		int strikeCount = 0;

		for (String number : defaultNumbers) {
			strikeCount += (userInputNumbers.get(defaultNumbers.indexOf(number)).equals(number)) ?
					1 : 0;
		}

		return strikeCount;
	}

	private int isBall(ArrayList<String> defaultNumbers) {
		return compareCountOfBall(defaultNumbers);
	}

	private ArrayList<String> arrayDeepCopy(ArrayList<String> baseArray) {
		String[] copyArray = new String[baseArray.size()];
		System.arraycopy(
				baseArray.toArray(),
				0,
				copyArray,
				0,
				baseArray.size());

		return new ArrayList<>(Arrays.asList(copyArray));
	}

	private int compareCountOfBall(ArrayList<String> defaultNumbers) {
		int userInputSize = userInputNumbers.size();
		int ballCount = 0;

		for (int i = 0; i < userInputSize; i++) {
			ArrayList<String> compareArray = arrayDeepCopy(defaultNumbers);
			compareArray.remove(i);
			ballCount += (compareArray.contains(userInputNumbers.get(i))) ? 1 : 0;
		}

		return ballCount;
	}
}
