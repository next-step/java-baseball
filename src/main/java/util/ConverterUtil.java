package util;

import ui.exception.GamePlayException;

import static ui.type.GamePlayExceptionType.INPUT_DATA_IS_NOT_VALID;

public class ConverterUtil {

	public static int convertStringToInteger(String value){
		try {
			return Integer.valueOf(value);
		}catch(NumberFormatException ex){
			throw GamePlayException.getInstance(INPUT_DATA_IS_NOT_VALID);
		}
	}
}
