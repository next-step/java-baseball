package common.models;

import common.code.GameErrorCode;
import common.exception.GameException;

public class ThreeNumbers {
	public static final int NUMBERS_SIZE = 3;
	private int[] numbers;
	
	public ThreeNumbers(int numbers) throws GameException {
		throwNumberRangeError(numbers, 999, 100);
		
		this.numbers = new int[3];
		this.numbers[0] = numbers/100;
		this.numbers[1] = (numbers%100)/10;
		this.numbers[2] = numbers%10;
		
		throwNonUniqueNumber(this.numbers[0], this.numbers[1], this.numbers[2]);
	}
	
	private void throwNonUniqueNumber(int number1, int number2, int number3) {
		if(number1 == number2 || number2 == number3 || number1 == number3) {
			throw new GameException(GameErrorCode.NUMBER_NON_UNIQUE_ERROR
					,GameErrorCode.NUMBER_NON_UNIQUE_ERROR.getErrorMessage());
		}
	}
	
	public ThreeNumbers(int number1,int number2,int number3) {
		this.numbers = new int[3];
		this.numbers[0] = number1;
		this.numbers[1] = number2;
		this.numbers[2] = number3;
		
		for(int i=0; i<NUMBERS_SIZE; i++) {
			throwNumberRangeError(numbers[i], 9, 1);
		}
		
		throwNonUniqueNumber(this.numbers[0], this.numbers[1], this.numbers[2]);
	}
	
	public int getNumber(int index) throws IllegalArgumentException {
		throwNumberRangeError(index, 2, 0);
		
		return numbers[index];
	}
	
	private void throwNumberRangeError(int number, int max, int min) {
		if (number > max || number < min) {
			throw new GameException(GameErrorCode.NUMBER_RANGE_ERROR
					,GameErrorCode.NUMBER_RANGE_ERROR.getErrorMessage() + " ("+min + " to " + max + ")");
		}
	}
}
