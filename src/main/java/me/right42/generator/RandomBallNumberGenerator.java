package me.right42.generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import me.right42.domain.BallNumbers;

public class RandomBallNumberGenerator implements BallNumbersGenerator {

	private final List<String> stringNumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

	@Override
	public BallNumbers generate() {
		Collections.shuffle(stringNumbers);
		return BallNumbers.create(stringNumbers.get(0) + stringNumbers.get(1) + stringNumbers.get(2));
	}
}
