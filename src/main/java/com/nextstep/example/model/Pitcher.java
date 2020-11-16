package com.nextstep.example.model;

import java.util.Scanner;

public class Pitcher {
	private Scanner sc;

	public Pitcher(Scanner sc) {
		this.sc = sc;
	}

	public String pitch() {
		System.out.print("숫자를 입력해주세요 : ");
		return sc.nextLine();
	}
}
