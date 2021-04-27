package common.models;

import common.code.GameErrorCode;
import common.exception.GameException;


/**
 * @brief
 * 3자리 숫자 관리 object
 * @details 3자리 숫자(attack, defend number)를 관리하는 obejct를 기술합니다..
 * @author SUNJU
 * @since 2021. 4. 27.
 * @version 1.0
 * @see
 * <pre>
 *     since          author              description
 *  ===========    =============    ===========================
 *  2021. 4. 27.     SUNJU         최초 생성
 * </pre>

 */
public class ThreeNumbers {
	public static final int NUMBERS_SIZE = 3;
	private int[] numbers;
	
	public ThreeNumbers(int number) throws GameException {
		throwNumberRangeError(number, 999, 100);
		
		this.numbers = new int[3];
		this.numbers[0] = number/100;
		this.numbers[1] = (number%100)/10;
		this.numbers[2] = number%10;
		
		throwNonUniqueNumber(this.numbers[0], this.numbers[1], this.numbers[2]);
		for(int i=0; i<NUMBERS_SIZE; i++) {
			throwNumberRangeError(numbers[i], 9, 1);
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
	
	private void throwNonUniqueNumber(int number1, int number2, int number3) {
		if(number1 == number2 || number2 == number3 || number1 == number3) {
			throw new GameException(GameErrorCode.NUMBER_NON_UNIQUE_ERROR
					,GameErrorCode.NUMBER_NON_UNIQUE_ERROR.getErrorMessage());
		}
	}
}
