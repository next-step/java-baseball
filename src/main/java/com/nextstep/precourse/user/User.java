package com.nextstep.precourse.user;

import java.util.Scanner;

import com.nextstep.precourse.util.PrintMessageEnum;

public class User {
	private Scanner scanner = new Scanner(System.in);

	public String getUserInputNumber() {
		System.out.println(PrintMessageEnum.ENTER_A_NUMBER.getMessage());
		return scanner.nextLine();
	}

}
