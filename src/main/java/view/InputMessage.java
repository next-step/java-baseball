package view;

import java.util.Scanner;

import domain.Numbers;

public class InputMessage {
	private Scanner scanner;

	public InputMessage(){
		this.scanner = new Scanner(System.in);
	}

	public char[] getInput(){
		char[] input = scanner.nextLine().toCharArray();
		if(isNull(input)) {
			OutputMessage.printMessage(OutputMessage.Message.NOTICE_ERROR_NULL);
			return null;
		}
		if(!hasThreeDigits(input)) {
			OutputMessage.printMessage(OutputMessage.Message.NOTICE_ERROR_SIZE);
			return null;
		}
		if(!isAllValidNumber(input)) {
			OutputMessage.printMessage(OutputMessage.Message.NOTICE_ERROR_INVALID_VALUE);
			return null;
		}

		return input;
	}

	private boolean isAllValidNumber(char[] input) {
		boolean isAllValid = true;
		int index = 0;
		while(isAllValid && index <Numbers.MAX_SIZE){
			isAllValid = isValid(input[index++]);
		}
		return isAllValid;
	}

	private boolean isValid(char c) {
		int number = Character.getNumericValue(c);
		return number>=Numbers.MIN_NUMBER && number<=Numbers.MAX_NUMBER;
	}

	private boolean hasThreeDigits(char[] input) {
		return input.length == Numbers.MAX_SIZE;
	}

	private boolean isNull(char[] input) {
		return input.length ==0;
	}
}
