package com.precourse.baseball.helper.validator;

import java.util.regex.Pattern;

/**
 * 사용자 Input 값을 검증하는 클래스
 * 사용방법 : Validator.validInput("123");
 * @author eoz
 * @version 1.0
 */
public class Validator {
	private static final String USER_GUESS_PATTERN = "^(?!.*(.).*\\1)[1-9]{3}$";
	private static final String GAME_CONTINUE_PATTERN = "^[1-2]{1}$";
	
	/**
     * 사용자가 입력한 추측값을 검증 한다.
     * @param String input 사용자가 입력한 추측값
     * @return 유요한 input일 경우 true를 반환.
     */
	public static boolean validInput(String input) {
		return Pattern.matches(USER_GUESS_PATTERN, input);
	}
	
	
	/**
     * 사용자가 입력한 게임 재개 및 종료 값을 검증한다. 
     * @param String input 사용자가 입력한 값
     * @return 유요한 input일 경우 true를 반환.
     */
	public static boolean validGameContinueInput(String input) {
		return Pattern.matches(GAME_CONTINUE_PATTERN, input);
	}
}
