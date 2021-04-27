package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.Game;

public class Converter {

	public static List<Integer> convertStringToIntegerList(String input, String delimiter) {
		List<Integer> InputNumbers = new ArrayList<>();
		String[] inputStr = input.split(delimiter);
		for (int index = 0; index < Game.NUMBER_LENGTH; index++) {
			InputNumbers.add(Integer.parseInt(inputStr[index]));
		}
		return InputNumbers;
	}
}
