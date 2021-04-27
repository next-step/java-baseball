package baseball.domain;

import baseball.exception.InvalidateBallNumberException;
import baseball.exception.InvalidateBallNumberSizeError;
import baseball.exception.InvalidateBallNumberValueError;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

public class BallNumber {

	public final static int MAX_SIZE = 3;
	public final static int MIN_SIZE = 0;
	public final static int MAX_VALUE = 9;
	public final static int MIN_VALUE = 1;

	private LinkedHashSet<Integer> numbers;

	public BallNumber() {
		this.numbers = new LinkedHashSet<>();
		Random random = new Random();
		while (this.numbers.size() != MAX_SIZE)
			this.numbers.add(random.nextInt(MAX_VALUE) + 1);
	}

	public BallNumber(int baseballNumbers) throws InvalidateBallNumberException {
		this.numbers = new LinkedHashSet<>();
		inputBaseBall(baseballNumbers);
		validate();
	}

	private void inputBaseBall(int baseballNumbers) {
		String[] splitBaseballNumbers = String.valueOf(baseballNumbers).split("");
		for (int index = 0; index < splitBaseballNumbers.length; index++)
			this.numbers.add(Integer.parseInt(splitBaseballNumbers[index]));
	}

	private void validate() {
		sizeValidate();
		Iterator<Integer> numbersIterator = this.numbers.iterator();
		while (numbersIterator.hasNext())
			valueValidate(numbersIterator.next());
	}

	private void sizeValidate() {
		if (this.numbers.size() != MAX_SIZE)
			throw new InvalidateBallNumberSizeError("Size : " + this.numbers.size());
	}

	private void valueValidate(int number) {
		if (number > MAX_VALUE || number < MIN_VALUE)
			throw new InvalidateBallNumberValueError("Ball Numbers : " + number);
	}

	public int getNumberByIndex(int index) {
		List<Integer> listNumbers = new ArrayList(this.numbers);
		return listNumbers.get(index);
	}

	@Override
	public String toString() {
		String ballNumberString = "";
		Iterator<Integer> numbersIterator = this.numbers.iterator();
		while (numbersIterator.hasNext())
			ballNumberString += numbersIterator.next();
		return ballNumberString;
	}

}
