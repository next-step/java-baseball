import java.util.ArrayList;

import java.util.HashSet;

public class Baseball {
	public static void main(String[] args) {
		System.out.println(pickDefaultNumbers().toString());
	}

	private static ArrayList<String> pickDefaultNumbers () {
		HashSet<String> numberSet = new HashSet<>();
		ArrayList<String> numbers = new ArrayList<>();

		while (numberSet.size() < 3) {
			int pickNumber = (int) (Math.random() * 9) + 1;
			numberSet.add("" + pickNumber);
		}

		numberSet.iterator().forEachRemaining(numbers::add);

		return numbers;
	}
}
