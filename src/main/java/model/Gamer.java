package model;

import util.CustomException;

import java.time.temporal.ValueRange;
import java.util.*;

public class Gamer {
	ArrayList<String> userInputNumbers = new ArrayList<>();

	public ArrayList<String> getUserInputNumbers() {
		return userInputNumbers;
	}

	private void setUserInputNumbers(ArrayList<String> userInputNumbers) {
		this.userInputNumbers = userInputNumbers;
	}

	public void inputNumberFromUser() throws
			CustomException.InvalidNumberFormatException,
			CustomException.InvalidNumberOfRangeException,
			CustomException.InvalidNumberOfSizeException {
		System.out.println("숫자를 입력해주세요 : ");
		Scanner scanner = new Scanner(System.in);
		String inputNumbers = scanner.nextLine();

		checkInputNumber(inputNumbers);
		setUserInputNumbers(convertStringToArray(inputNumbers));
	}

	private void checkInputNumber(String input) throws
			CustomException.InvalidNumberFormatException,
			CustomException.InvalidNumberOfRangeException,
			CustomException.InvalidNumberOfSizeException {
		LinkedHashSet<String> linkedHashSet = checkDuplicateNumber(input);
		validNumberSize(linkedHashSet);
	}

	private LinkedHashSet<String> checkDuplicateNumber(String input) throws
			CustomException.InvalidNumberFormatException,
			CustomException.InvalidNumberOfRangeException {
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		for (char number : input.toCharArray()) {
			int convertNumberFromChar = parseIntOrThrow(number);
			linkedHashSet.add(String.valueOf(validNumberRange(convertNumberFromChar)));
		}

		return linkedHashSet;
	}

	private int parseIntOrThrow(char number) throws
			CustomException.InvalidNumberFormatException {
		OptionalInt optional = OptionalInt.of(Integer.parseInt(String.valueOf(number)));
		return optional.orElseThrow(() ->
				new CustomException.InvalidNumberFormatException("잘못된 형식입니다. 숫자만 입력해주세요."));
	}

	private int validNumberRange(int number) throws
			CustomException.InvalidNumberOfRangeException {
		if (number < 1 || number > 9) {
			throw new CustomException.InvalidNumberOfRangeException("숫자는 1 ~ 9사이로 입력해주세요");
		}

		return number;
	}

	private void validNumberSize(LinkedHashSet<String> linkedHashSet) throws
			CustomException.InvalidNumberOfSizeException {
		if (linkedHashSet.size() != 3) {
			throw new CustomException.InvalidNumberOfSizeException("중복되지 않은 숫자로 3개를 입력해주세요.");
		}
	}

	private ArrayList<String> convertStringToArray(String input) {
		ArrayList<String> convertArray = new ArrayList<>();
		for (char number : input.toCharArray()) {
			convertArray.add(String.valueOf(number));
		}

		return convertArray;
	}
}
