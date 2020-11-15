package domain;

import exception.CustomException;

public class BaseballNumber {
	public static final int MAX_SIZE = 3;
	public static final int MAX_NUMBER = 9;
	public static final int MIN_NUMBER = 1;

	BaseballNumber(int units, int tens, int hundreds) {
		this.units = checkValid(units);
		this.tens = checkValid(tens);
		this.hundreds = checkValid(hundreds);
	}

	BaseballNumber(String units, String tens, String hundreds) {
		this.units = checkValid(Integer.parseInt(units));
		this.tens = checkValid(Integer.parseInt(tens));
		this.hundreds = checkValid(Integer.parseInt(hundreds));
	}

	private final int units;
	private final int tens;
	private final int hundreds;

	public int getUnits() {
		return units;
	}

	public int getTens() {
		return tens;
	}

	public int getHundreds() {
		return hundreds;
	}

	public boolean isContain(int number) {
		return units == number || tens == number || hundreds == number;
	}

	private int checkValid(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER)
			throw new CustomException.BaseballNumberNotAvailableException();

		return number;
	}

	@Override
	public String toString() {
		return String.valueOf(hundreds) + tens + units;
	}
}

