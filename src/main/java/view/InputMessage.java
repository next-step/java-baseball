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
			OutputMessage.printMessage(Message.NOTICE_ERROR_NULL);
			return null;
		}
		if(!hasValidLength(input, Numbers.MAX_SIZE)) {
			OutputMessage.printMessage(Message.NOTICE_ERROR_SIZE);
			return null;
		}
		if(!isAllValidNumber(input)) {
			OutputMessage.printMessage(Message.NOTICE_ERROR_INVALID_VALUE);
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

	private boolean hasValidLength(char[] input, int maxSize) {
		return input.length == maxSize;
	}

	private boolean isNull(char[] input) {
		return input.length ==0;
	}

	public int getDecisionCode() {
		char[] code = scanner.nextLine().toCharArray();
		if(isNull(code)) {
			OutputMessage.printMessage(Message.NOTICE_ERROR_NULL);
			return -1;
		}
		if(!isValidCode(code)){
			OutputMessage.printMessage(Message.NOTICE_ERROR_INVALID_STATUS_CODE);
			return -1;
		}
		return Character.getNumericValue(code[0]);

	}
	private boolean isValidCode(char[] code) {
		boolean hasValidCode = false;
		int codeNumericValue = Character.getNumericValue(code[0]);
		if(code.length ==1 && (codeNumericValue == 1 || codeNumericValue == 2)) hasValidCode = true;
		return hasValidCode;

	}
}
