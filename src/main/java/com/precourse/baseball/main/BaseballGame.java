package com.precourse.baseball.main;

import com.precourse.baseball.answer.BaseballAnswer;
import com.precourse.baseball.count.BaseballCount;
import com.precourse.baseball.helper.display.DisplayHelper;
import com.precourse.baseball.helper.input.InputHelper;
import com.precourse.baseball.user.BaseballUser;


/**
 * 숫자야구 게임 진행 클래스
 * @author eoz
 * @version 1.0
 */

public class BaseballGame {

	public static void main(String[] args) {		
		
		BaseballAnswer answer = new BaseballAnswer();
		BaseballUser user = new BaseballUser();
		BaseballCount ballCount = new BaseballCount();
		
		boolean inGame = true;
				
		answer.generate();
		
		while( inGame ) {
			
			DisplayHelper.inputMessage();
			
			ballCount.init();
			
			ballCount.refereeCall( answer.getAnswer() , user.getUserGuess() );
			
			ballCount.result();

			if( ballCount.isStrikeOut() ) {
				inGame = InputHelper.continueGame();
				answer.shouldReset(inGame);
			}
			
		}
		
	}

}
