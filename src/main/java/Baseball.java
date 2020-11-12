import java.util.ArrayList;

import java.util.HashSet;

public class Baseball {

	static ArrayList<String> defaultNumbers = new ArrayList<>();
	static ArrayList<String> userInputNumbers = new ArrayList<>();

	public static void main(String[] args) {
		pickDefaultNumbers();
		System.out.println(defaultNumbers.toString());

		System.out.println("숫자를 입력해주세요 : ");
	}

	private static void pickDefaultNumbers() {
		HashSet<String> numberSet = new HashSet<>();

		while (numberSet.size() < 3) {
			int pickNumber = (int) (Math.random() * 9) + 1;
			numberSet.add("" + pickNumber);
		}

		numberSet.iterator().forEachRemaining(defaultNumbers::add);
	}

	private static void inputNumberFromUser() {

	}
}
