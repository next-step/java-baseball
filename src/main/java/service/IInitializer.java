package service;

import java.util.Map;

public interface IInitializer {
	Map<Integer, Integer> initComputerNumber();

	int[] initPlayerNumber(final int input);
}
