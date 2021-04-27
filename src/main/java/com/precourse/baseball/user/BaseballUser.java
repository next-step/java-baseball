package com.precourse.baseball.user;

import com.precourse.baseball.helper.input.InputHelper;



/**
 * 숫자야구 게임 사용자 추측값 생성 클래스
 * 사용방법 :	BaseballUser user = new BaseballUser();
 * @author eoz
 * @version 1.0
 */
public class BaseballUser {
	
	/**
	* InputHelper 로부터 input을 받아온뒤 배열로 리턴한다.
	* 
	* @return int[] 사용자 추측값이 들어있는 배열
	*/
	public int[] getUserGuess() {
		String userGuess = InputHelper.getBallInput();
		
		return stringToIntArray( userGuess );
	}

	private static int[] stringToIntArray(String str) {
		int[] digits = new int[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			digits[i] = str.charAt(i) - '0';
		}
		
		return digits;
	}

}
