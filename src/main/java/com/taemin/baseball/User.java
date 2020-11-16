package com.taemin.baseball;

import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class User {
	
	public LinkedHashSet<Integer> getUserNumbers() {
		LinkedHashSet<Integer> userNumbers = null;
	    while(!isVaildation(userNumbers)) {
	    	int userInputNumbers = inputUserNumber();
	    	userNumbers = toLinkedHashSet(userInputNumbers);
	    }
		return userNumbers;
	}
	
	private int inputUserNumber() {
		int userInputNumbers = 0;
		try {
			System.out.print("숫자를 입력해주세요 : ");
			Scanner scanner = new Scanner(System.in); 
	    	userInputNumbers = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("정수 3자리를 입력하주십시오.");
			userInputNumbers = inputUserNumber();
		}
    	return userInputNumbers;
		
	}
	
	private LinkedHashSet<Integer> toLinkedHashSet(int userInputNumbers) {
		LinkedHashSet<Integer> userNumbers = new LinkedHashSet<Integer>();
		int firstNumber = userInputNumbers/100;
		int secondNumber = userInputNumbers/10 - (userInputNumbers/100 * 10);
		int thirdNumber = userInputNumbers - (firstNumber * 100) - (secondNumber * 10);
		userNumbers.add(firstNumber);
		userNumbers.add(secondNumber);
		userNumbers.add(thirdNumber);
		return userNumbers;
	}
	
	private boolean isVaildation(LinkedHashSet<Integer> userNumbers) {
		if(userNumbers == null)
			return false;
		if(!isZero(userNumbers))
			return false;
		if(!isDuplication(userNumbers))
			return false;
		if(!isThreeDigits(userNumbers))
			return false;
		return true;
	}
	
	private boolean isZero(LinkedHashSet<Integer> userNumbers) {
		if(userNumbers.contains(0)) {
			System.out.println("입력한 숫자 중 0이 포함되어있습니다.");
			return false;
		}
		return true;
	}
	
	private boolean isDuplication(LinkedHashSet<Integer> userNumbers) {
		if(userNumbers.size() != 3) {
			System.out.println("입력한 숫자가 중복됩니다.");
			return false;
		}
		return true;
	}
	
	private boolean isThreeDigits (LinkedHashSet<Integer> userNumbers) {
		if(userNumbers.iterator().next() > 9) {
			System.out.println("입력한 숫자가 4자리 이상입니다.");
			return false;
		}
		return true;
	}
	
}
