package com.precourse.baseball.count;

import java.util.Iterator;
import java.util.Set;

import com.precourse.baseball.helper.display.DisplayHelper;

/**
 * 숫자야구 게임 정답값과 추측값을 판별하는 클래스
 * 사용방법 : 	BaseballCount ballCount = new BaseballCount();
 * @author eoz
 * @version 1.0
 */

public class BaseballCount {
	private int strike;
	private int ball;
	
	public void init() {
		this.ball = 0;
		this.strike = 0;
	}

	/**
	* 정답값과 추측값을 받아 스트라이크, 볼 여부를 판정한다.
	* @param Set<Integer> answer- 컴퓨터가 생성한 정답값
	* @param int[] userGuess- 사용자가 입력한 추측값
	*/
	public void refereeCall(Set<Integer> answer, int[] userGuess) {	
		
		getStrikeCount(userGuess, answer.iterator());
		
		getBallCount(answer, userGuess);
		
	}
	
	/**
	* 현재 볼 카운트를 사용자에게 출력한다.	 
	* 
	*/
	public void result() {
		if( this.isNothing() ) {
			DisplayHelper.nothingMeesage();
			return;
		}
		
		DisplayHelper.resultMessage(this.strike, this.ball);
	}
	
	private void getStrikeCount(int[] userGuess, Iterator<Integer> it) {
		for(int i=0; i<userGuess.length; i++) {
			if(userGuess[i] == it.next()) {
				this.increseStrikeCount();
			}			
		}
	}
	
	private void getBallCount(Set<Integer> answer, int[] userGuess) {
		for(int i=0; i<userGuess.length; i++) {
			if(answer.contains(userGuess[i])){
				this.increseBallCount();
			}
		}
		
		this.ball -= this.strike;
	}
	
	/**
	* 현재 볼 카운트가 Nothing 인지 판별한다.
	* @return 모두 0이면 true, 아니면 false를 리턴 	
	*/
	public boolean isNothing() {
		return ( this.strike == 0 && this.ball == 0 );
	}	
	
	/**
	* 현재 볼 카운트가 3 스트라이크인지 판별한다.
	* @return 스트라이크 카운트가 3이면 true, 아니면 false를 리턴
	*/
	public boolean isStrikeOut() {
		return this.strike == 3;
	}	
	
	/**
	* 현재 스트라이크 카운트를 1 증가 한다.
	* 
	*/
	private void increseStrikeCount() {
		this.strike++;
	}
	
	/**
	* 현재 볼 카운트를 1 증가 한다.
	* 
	*/
	private void increseBallCount() {
		this.ball++;
	}
	
	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

}
