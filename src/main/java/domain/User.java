package domain;

import java.util.Scanner;

import util.CheckNumber;

public class User {

	private final static String INSERT_MESSAGE = "숫자를 입력하세요 : ";
	private final static int NUMBER_LENGTH = 3;
	
	private int[] userNumber = null;
	private String tempNumber = "";
	private boolean checkYN = false;
	private Scanner scan = null;
	private CheckNumber chkNb = null;
	
	public User() {
		chkNb = new CheckNumber();
		userNumber = new int[NUMBER_LENGTH];
	}

	public int[] getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int[] userNumber) {
		this.userNumber = userNumber;
	}
	
	public void swingNumber() {
		
		while(!checkYN) {
			scan = new Scanner(System.in);
			System.out.println(INSERT_MESSAGE);
			tempNumber = scan.next();
			checkYN = chkNb.checkNumber(tempNumber);
		}
		
		stringToIntArr();
		
		checkYN = false;
	}
	
	public void stringToIntArr() {
		String[] strNumber = tempNumber.split("");
		for(int idx = 0; idx < strNumber.length ; idx++) {
			userNumber[idx] = Integer.parseInt(strNumber[idx]);
		}
	}
	
	public void scanClose() {
		if(scan != null) {
			scan.close();
		}
	}
}
