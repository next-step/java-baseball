package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Baseball {
	ArrayList<String> defaultNumbers;

	public Baseball() {
		setDefaultNumbers();
	}

	public ArrayList<String> getDefaultNumbers() {
		return defaultNumbers;
	}

	public void setDefaultNumbers() {
		LinkedHashSet<String> linkedHashMap = new LinkedHashSet<>();
		defaultNumbers = new ArrayList<>();

		while (linkedHashMap.size() < 3) {
			linkedHashMap.add("" + ((int) (Math.random() * 9) + 1));
		}

		linkedHashMap.iterator().forEachRemaining(defaultNumbers::add);
	}
}
