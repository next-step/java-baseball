package com.baseball.woowahan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputGenerator {

	public String start() {
		String userInput = null;
		System.out.println("===== 야구 게임을 시작합니다. 중복되지 않은 1~9 숫자를 3개 입력 하세요. (ex. 135) =====");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			userInput = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInput;
	}
}
