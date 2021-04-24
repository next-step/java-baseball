package com.chajs226.baseball;

import java.util.Random;
import java.util.Scanner;

enum checkRetry {RETRY, END, ERROR}
public class BaseballGame {
	
	Scanner scan;
	
	public BaseballGame() {
		scan = new Scanner(System.in);
	}
	
	@Override
	protected void finalize() throws Throwable {
		scan.close();
	}
	
	public void startGame() {
		
		checkRetry isRetry = checkRetry.RETRY;
		
		while (isRetry == checkRetry.RETRY)
		{
			String randomNumbers = makeRandomNumbers();
			progressGame(randomNumbers);
			isRetry = retryOrEndGame();
		}
	}
	
	public void progressGame(String randomNumbers) {
		
		boolean success = false;
		
		
		while (success == false) {
			System.out.println("숫자를 입력해주세요 : ");
			String inputNumbers = scan.next();
			//TODO: 입력값 비교 체크. 성공 시, success = true		
			success = true;
			}
	}
	
	public checkRetry retryOrEndGame() {
			
		String input = null;
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
		input = scan.next();			
		
		if(input.equals("1"))
			return checkRetry.RETRY;		
		
		if(input.equals("2"))
			return checkRetry.END;
		
		return checkRetry.ERROR;
	}
	
	public String makeRandomNumbers() {
		
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
