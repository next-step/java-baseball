package io.github.sejoung.baseball;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

public class BaseBallGameParameterized {
	protected static Stream<Arguments> generateThreeStrikeArgumentsStream() {
		List<Arguments> listOfArguments = new LinkedList<>();
		listOfArguments.add(Arguments.of(Arrays.asList(1, 2, 3), "123"));
		listOfArguments.add(Arguments.of(Arrays.asList(4, 5, 6), "456"));
		return listOfArguments.stream();
	}

	protected static Stream<Arguments> generateBallArgumentsStream() {
		List<Arguments> listOfArguments = new LinkedList<>();
		listOfArguments.add(Arguments.of(Arrays.asList(4, 5, 6), "645", 3));
		listOfArguments.add(Arguments.of(Arrays.asList(4, 5, 6), "561", 2));
		listOfArguments.add(Arguments.of(Arrays.asList(4, 5, 6), "124", 1));
		return listOfArguments.stream();
	}
}
