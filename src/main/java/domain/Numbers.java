package domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

	public static final int MAX_SIZE = 3;
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 9;

	private final List<Integer> digits;

	public Numbers(){
		this.digits = new ArrayList<>();
	}

	public void add(int digit) {
		if(!canAddNewDigit()) return;

		if(isBetweenRange(digit)){
			digits.add(digit);
		}
	}

	private boolean canAddNewDigit() {
		return digits.size()<MAX_SIZE;
	}

	private boolean isBetweenRange(int digit){
		return digit>=MIN_NUMBER && digit<=MAX_NUMBER;
	}

	public List<Integer> getDigits() { return digits; }

	public int length(){
		return digits.size();
	}

}
