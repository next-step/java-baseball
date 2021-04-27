package baseball.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import baseball.domain.Game;
import baseball.domain.GameStatus;
import baseball.view.PrintMessage;

public class Validation {
	public static boolean equalsWithGameNumberLength(int InputLength) {
		return (InputLength == Game.NUMBER_LENGTH);
	}

	public static boolean isThreeDigits(String InputStr) {
		if (!equalsWithGameNumberLength(InputStr.length())) {
			PrintMessage.printErrorThreeDigits();
			return false;
		}
		return true;
	}

	public static boolean isDigitExistsOnly(String InputStr) {
		if (!InputStr.matches("[1-9]{3}")) {
			PrintMessage.printErrorDigitExistsOnly();
			return false;
		}
		return true;
	}

	public static boolean isAllDifferentDigits(String InputStr) {
		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList(InputStr.split("")));
		if (!equalsWithGameNumberLength(set.size())) {
			PrintMessage.printErrorAllDifferentDigits();
			return false;
		}
		return true;
	}

	public static boolean checkInputNumber(String InputStr) {
		if (!isThreeDigits(InputStr) || !isDigitExistsOnly(InputStr) || !isAllDifferentDigits(InputStr)) {
			return false;
		}
		return true;
	}


}
