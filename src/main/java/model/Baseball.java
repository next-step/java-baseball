package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Baseball {
	private final int BASEBALL_MAX_SIZE = 3;
	private final int BASEBALL_END_RANGE = 9;

	private ArrayList<String> defaultNumbers;

	public Baseball() {
		setDefaultNumbers();
	}

	public ArrayList<String> getDefaultNumbers() {
		return defaultNumbers;
	}

	public void setDefaultNumbers() {
		LinkedHashSet<String> linkedHashMap = new LinkedHashSet<>();
		defaultNumbers = new ArrayList<>();

		while (linkedHashMap.size() < BASEBALL_MAX_SIZE) {
			linkedHashMap.add("" + ((int) (Math.random() * BASEBALL_END_RANGE) + 1));
		}

		linkedHashMap.iterator().forEachRemaining(defaultNumbers::add);
	}
}
