package com.chajs226.baseball;

import java.util.Random;

public class BaseballGame {
	public static void main(String[] args) {
		System.out.println("Welcome to Baseball Game");	
		
	}
	
	public String makeRamdomNumbers() {
		
		Random rd = new Random();		
		String getNumbers = "";
		int tempNumber;
		
		while ( getNumbers.length() < 3 )
		{
			tempNumber = rd.nextInt(8)+1;
			getNumbers = appendNumber(getNumbers, Integer.toString(tempNumber));			
		}
		
		return getNumbers;		
	}	
	
	private String appendNumber(String getNumbers, String tempNumber ) {
		
		if(getNumbers.length() == 0)
			return tempNumber;
		
		if( (getNumbers.length() == 1 && getNumbers != tempNumber) ||
			(getNumbers.length() == 2 && getNumbers.split("")[0] != tempNumber && getNumbers.split("")[1] != tempNumber) )				
			return getNumbers+tempNumber;
		
		return getNumbers;
	}
}
