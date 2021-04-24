package com.baseball.woowahan;

import java.io.BufferedReader;
import java.io.IOException;

public class UserInputGenerator {

	private BufferedReader bufferedReader;

	public UserInputGenerator(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	public String enterInput() throws IOException {
		System.out.println(Message.INPUT.getMessage());
		return bufferedReader.readLine();
	}
}
