package domain;

import static java.lang.Integer.*;

import utils.BusinessException;
import utils.BusinessException.BaseballNumberOnlyNumberException;

/**
 * @author : byungkyu
 * @date : 2020/11/12
 * @description : 야구게임에서 사용되는 숫자
 **/
public class BaseballNumber {
	private int value;

	public BaseballNumber(int value) {
		validateRange(value);
		this.value = value;
	}

	private void validateRange(int value) {
		if (value < BaseballNumbers.MINIMUM_NUMBER_OF_BASEBALL_GAME
			|| value > BaseballNumbers.MAXIMUM_NUMBER_OF_BASEBALL_GAME) {
			throw new BusinessException.BaseballNumberOutOfInvalidArrangeException();
		}
	}

	public BaseballNumber(String str) {
		try {
			this.value = parseInt(str);
			validateRange(this.value);
		} catch (NumberFormatException e) {
			throw new BaseballNumberOnlyNumberException();

		}
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;

		BaseballNumber check = (BaseballNumber)obj;
		return check.value == value;
	}
}
