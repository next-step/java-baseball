package me.right42.generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import me.right42.domain.BallNumbers;

public class RandomBallNumberGenerator implements BallNumbersGenerator {

	private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	private static final Integer START_INDEX = 0;

	private static final Integer END_INDEX = 3;

	@Override
	public BallNumbers generate() {
		Collections.shuffle(numbers);
		return BallNumbers.create(numbers.subList(START_INDEX, END_INDEX));
	}
}
