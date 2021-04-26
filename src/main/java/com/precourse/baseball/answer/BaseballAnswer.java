package com.precourse.baseball.answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * 숫자야구 게임 정답값 생성 클래스.
 * 사용방법 : BaseballAnswer answer = new Answer();
 * @author eoz
 * @version 1.0
 */

public class BaseballAnswer {
	private static final int BEGIN_NUMBER = 1;
	private static final int END_NUMBER = 9;
	private static final int BALL_COUNT = 3;
	
	/**
    * 컴퓨터가 임의로 생성한 3개의 정수를 담는 컬렉션
    * 중복 저장을 방지하기 위해 Set 자료구조 선택
    */
	private Set<Integer> answer = new LinkedHashSet<Integer>();
	
	public BaseballAnswer() {

	}

	/**
	* 1~9 사이의 자연수 3개를 임의로 생성하여 저장 한다.
	*/
	public void generate() {
		List<Integer> numberCandidates = getNumberCandidates();
				
		pickSomeNumbers(numberCandidates);
	}
	
	private static List<Integer> getNumberCandidates() {
		List<Integer> numberCandidates = new ArrayList<>();
		
		for(int i = BEGIN_NUMBER ; i <= END_NUMBER ; i++) {
			numberCandidates.add(i);
        }
		return numberCandidates;
	}

	private void pickSomeNumbers(List<Integer> numberCandidates) {
		Collections.shuffle(numberCandidates);
		
		for(int i=0;i<BALL_COUNT;i++) {
			this.answer.add(numberCandidates.get(i));
		}
	}
	
	/**
	* 정답값을 다시 생성한다.
	*/
	public void shouldReset(boolean doReset) {	
		if(doReset) {
			this.answer.clear();
			this.generate();
		}
	}	
	
	public Set<Integer> getAnswer() {
		return answer;
	}
	
}
