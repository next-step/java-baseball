package ui.service;

import ui.dto.InputDataDto;
import ui.exception.GamePlayException;

import java.util.Objects;

import static ui.type.GamePlayExceptionType.INPUT_DATA_IS_NULL;
import static ui.type.GamePlayExceptionType.INPUT_DATA_DIGIT_NOT_MATCH;
import static ui.type.GamePlayExceptionType.INPUT_DATA_CONTAIN_ZERO;

public class InputDataValidator {

	private static final int LIMIT_DIGIT = 3;

	public static void preValidateInputData(String value){
		if(Objects.isNull(value)){
			throw GamePlayException.getInstance(INPUT_DATA_IS_NULL);
		}
		if(value.length() != LIMIT_DIGIT){ // 3자리가 아닐 경우
			throw GamePlayException.getInstance(INPUT_DATA_DIGIT_NOT_MATCH);
		}
	}

	public static void postValidateInputData(InputDataDto inputData){
		if(inputData.containZero()){  // 0값을 포함하면 입력값 오류
			throw GamePlayException.getInstance(INPUT_DATA_CONTAIN_ZERO);
		}
	}
}
