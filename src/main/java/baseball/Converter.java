package baseball;

public class Converter {

	public Converter() {
	}

	public boolean isThreeDigits(String raw) {
		if (raw.length() != 3) {
			return false;
		}

		if (!isNumber(raw)) {
			return false;
		}

		return toNumber(raw) > 99;
	}

	public int toNumber(String raw) {
		return Integer.parseInt(raw);
	}

	public boolean isNumber(String raw) {
		try {
			toNumber(raw);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public int[] toArray(int number) {
		int[] array = new int[3];

		for (int i = 2; i >= 0; i--) {
			array[i] = number % 10;
			number /= 10;
		}

		return array;
	}
}
