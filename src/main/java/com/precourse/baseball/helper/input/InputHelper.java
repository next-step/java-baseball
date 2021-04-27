package com.precourse.baseball.helper.input;

import java.util.Scanner;

import com.precourse.baseball.helper.display.DisplayHelper;
import com.precourse.baseball.helper.validator.Validator;

/**
 * 숫자야구 게임 관련 표준 입력을 처리하는 클래스
 * 사용방법 : InputHelper.getBallInput();
 * @author eoz
 * @version 1.0
 */
public class InputHelper {
	private static final String GAME_CONTINUE = "1";
	private static final String GAME_EXIT = "2";
	private static Scanner sc = new Scanner(System.in);
	
	
	public static String getBallInput() {
		String result = "";
		while(true) {
			String input = sc.nextLine();
			if( Validator.validInput(input) ) {
				result = input;
				break;
			}
			
			DisplayHelper.wrongInputMessage();
			DisplayHelper.inputMessage();
		}
		
		return result;
	}
	
	public static boolean continueGame() {
		DisplayHelper.strikeOutMessage();
		DisplayHelper.countinueMessage();	
				
		String input = "";
		while(true) {
			input = sc.nextLine();
			if( Validator.validGameContinueInput(input) ) {
				break;
			}
			
			DisplayHelper.countinueMessage();	
		}
		
		return GAME_CONTINUE.equals(input);
	}

}
