package baseball.player;

import java.util.HashSet;

import baseball.util.GameStatus;

public class InputValidate {

	public static void validationChecker(String input) {	
		isVaildSize(input);
		isVaildNumber(input);
		isDifferentEachOther(input);
		isContainZero(input);
	}

	// 입력한 자릿수가 맞는지 여부
	private static void isVaildSize(String input) {		
		if (input.length() != GameStatus.BALL_SIZE) {
			throw new IllegalArgumentException(GameStatus.BALL_SIZE + "자리 숫자여야 합니다.");
		}
	}
	
	// 숫자 여부
	private static void isVaildNumber(String input) {
		try {
			Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
		}
	}
	
	// 중복된 숫자는 없는지 여부
	private static void isDifferentEachOther(String input) {
		HashSet<Character> differentSet = new HashSet<Character>();		
		for (int i = 0; i < input.length(); i++) {
			differentSet.add(input.charAt(i));
		}		
		if (differentSet.size() != GameStatus.BALL_SIZE) {
			throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
		}
	}
	
	// 0이 포함되어 있는지 여부 
	private static void isContainZero(String input) {		
		if (input.contains("0")) {
			throw new IllegalArgumentException("숫자 0이 포함되어 있습니다.");
		}
	}

}
