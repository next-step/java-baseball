package ui.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InputDataDto {
	private List<Integer> numbers = new ArrayList<>();

	public Integer getNumberWithDigit(final Digit digit){
		return numbers.get(digit.index);
	}

	public void addNumber(final int num){
		this.numbers.add(num);
	}

	public boolean containZero(){
		return numbers.contains(0);
	}

	/**
	 * int type을 각자리수로 나누어 List<Integer> type을 가지는 DTO로 반환
	 * @param inputData
	 * @return
	 */
	public static InputDataDto getInstance(Integer inputData){
		if(Objects.isNull(inputData)) return null;
		InputDataDto inputDataDto = new InputDataDto();
		int digit = 100;
		for(int i = 0; i < 3; i++){
			int calculatedValue = inputData / digit;
			inputData = inputData % digit;
			digit = digit / 10;
			inputDataDto.addNumber(calculatedValue); // 백의 자리부터 삽입
		}
		return inputDataDto;
	}

	public enum Digit{
		HUNDRED(0),
		TEN(1),
		ONE(2);

		private int index;
		Digit(final int index){
			this.index = index;
		}
	}
}
