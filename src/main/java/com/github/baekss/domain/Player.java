package com.github.baekss.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

import com.github.baekss.InputChecker;

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
	 * 플레이어가 숫자를 입력하는 기능
	 * @param invalidValue 유효하지 않은 값
	 * @param length 유효한 입력값 길이
	 * @return 플레이어의 입력값
	 */
	public Set<Integer> putThreeDigitNumber(String invalidValue, int length) throws Exception {
		String threeDigitNumberString = "";
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			threeDigitNumberString = reader.readLine();
			checkInput(threeDigitNumberString, invalidValue, length);
		} catch (IOException ioe) {
			throw ioe;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return toIntegerSet(threeDigitNumberString);
	}
	
	/**
	 * 플레이어의 입력값 검증 기능
	 */
	private boolean checkInput(String input, String invalidValue, int length) {
		boolean flag = InputChecker.checkNumberFormat(input)
						&& InputChecker.checkInputLength(input, length)
						&& InputChecker.checkInvalidValue(input, invalidValue)
						&& InputChecker.isUniqueEachValue(input, length);
		return flag;
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
