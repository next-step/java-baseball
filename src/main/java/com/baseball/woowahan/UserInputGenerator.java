package com.baseball.woowahan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputGenerator {

	public String start() {
		String userInput = null;
		System.out.println(Message.INPUT.getMessage());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			userInput = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInput;
	}
}
