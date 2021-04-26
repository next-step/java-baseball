package com.chajs226.baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
	
	Scanner scan;
	int strikeCount = 0;
	int ballCount = 0;
	boolean isRetry = true;
	
	public BaseballGame() {
		scan = new Scanner(System.in);
	}
	
	@Override
	protected void finalize() throws Throwable {
		scan.close();
	}
	
	public void startGame() {		
		while (isRetry == true)
		{	
			resetBallCount();
			String randomNumbers = generateRandomNumbers();
			inputNumbersAndCheck(randomNumbers);
			isRetry = inputRetryOrEnd();
		}
	}
	
	public void resetBallCount() {
		strikeCount = 0;
		ballCount = 0;
	}
	
	public void inputNumbersAndCheck(String randomNumbers) {		
		boolean success = false;		
		
		while (success == false) {
			resetBallCount();
			System.out.print("숫자를 입력해주세요 : ");
			String inputNumbers = scan.next();
			compareInputAndRandomNumber(inputNumbers, randomNumbers);
			success = checkThreeStrike();
		}
	}
	
	public boolean validateInputNumberLength(String inputNumbers) {
		if (inputNumbers.length() != 3) {
			return false;
		}		
		return true;
	}
	
	public void compareInputAndRandomNumber(String inputNumbers, String randomNumbers) {		
		if(validateInputNumberLength(inputNumbers) == false)
			throw new RuntimeException("3자리 숫자만 입력 가능합니다.");
		
		String[] splitedInputNumber = inputNumbers.split("");
		
		for (int i=0; i<3; i++) {
			updateBallCount(i+1, splitedInputNumber[i], randomNumbers);
		}
		showResultMessages();	
	}
	
	public boolean checkThreeStrike() {
		if (strikeCount == 3)
			return true;
		
		return false;	
	}
	
	public void showResultMessages() {
		if (strikeCount == 3)
			System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		
		if (strikeCount == 0 && ballCount == 0)
			System.out.print("낫싱");
		
		if (strikeCount == 1 || strikeCount == 2)
			System.out.print(strikeCount + "스트라이크 ");
		
		if (ballCount == 1 || ballCount == 2)
			System.out.print(ballCount + "볼");
				
		System.out.print("\n");
	}
	
	public void updateBallCount(int position, String inputNumber, String randomNumbers) {		
		if( position == randomNumbers.indexOf(inputNumber) + 1)
			strikeCount = strikeCount+1;
		
		if( position != randomNumbers.indexOf(inputNumber) + 1 && randomNumbers.indexOf(inputNumber) != -1 )
			ballCount = ballCount+1;
	}
	
	public boolean inputRetryOrEnd() {	
		boolean isInput = true;
		String inputMenu = null;
		
		while(isInput) {			
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 : ");
			inputMenu = scan.next();	
			isInput = validateInputRetry(inputMenu);
		}		
		return checkInputRetry(inputMenu);
	}
	
	public boolean checkInputRetry(String input) {
		if(input.equals("1"))
			return true;		
		
		if(input.equals("2"))
			return false;
		
		return false;
	}
	
	public boolean validateInputRetry(String input) {
		if(!input.equals("1") && !input.equals("2")) {
			System.out.println("1 또는 2만 입력 가능합니다.");
			return true;
		}
		return false;
	}
	
	public String generateRandomNumbers() {		
		Random rd = new Random();		
		String generatedNumbers = "";
		int tempNumber;
		
		while ( generatedNumbers.length() < 3 )
		{
			tempNumber = rd.nextInt(8)+1;
			generatedNumbers = appendNumber(generatedNumbers, Integer.toString(tempNumber));			
		}		
		return generatedNumbers;		
	}	
	
	public String appendNumber(String getNumbers, String tempNumber ) {		
		if(getNumbers.length() == 0)
			return tempNumber;
		
		if( (getNumbers.length() == 1 && !getNumbers.equals(tempNumber)) ||
			(getNumbers.length() == 2 && !getNumbers.split("")[0].equals(tempNumber) && !getNumbers.split("")[1].equals(tempNumber)))
			return getNumbers+tempNumber;
		
		return getNumbers;
	}
}
