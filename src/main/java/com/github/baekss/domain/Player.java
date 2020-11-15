package com.github.baekss.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class Player {
	
	private JoinStatus status;
	
	private Player(JoinStatus status) {
		this.status = status;
	}
	
	public void setStatus(JoinStatus status) {
		this.status = status;
	}
	
	public JoinStatus getStatus() {
		return status;
	}
	
	/**
	 * 플레이어의 입력값을 반환한다.
	 * @param threeDigitNumberString 플레이어의 입력값
	 * @return 플레이어의 입력값(LinkedHashSet 형태)
	 */
	public Set<Integer> getThreeDigitNumber(String threeDigitNumberString) {
		return toIntegerSet(threeDigitNumberString);
	}
	
	private LinkedHashSet<Integer> toIntegerSet(String input) {
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < input.length(); i++) {
			String eachValue = input.substring(i, i+1);
			set.add(Integer.parseInt(eachValue));
		}
		return set;
	}
	
	/**
	 * Player 객체를 정적 메소드를 이용해 생성 및 초기화한다.
	 * @param status 플레이어 Game Join 상태
	 * @return Player 객체
	 */
	public static Player createPlayer(JoinStatus status) {
		return new Player(status);
	}
}
