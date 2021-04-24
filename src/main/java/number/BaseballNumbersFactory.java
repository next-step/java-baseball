package number;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbersFactory {
	
	private static BaseballNumbersFactory baseballNumbersFactory = new BaseballNumbersFactory();
	private BaseballNumbersFactory() {}
	
	public static BaseballNumbersFactory getInstance() {
		return baseballNumbersFactory;
	}
	
	public BaseballNumbers baseballNumbers(int number) {
		return new BaseballNumbers(intToList(number));
	}

	private List<Integer> intToList(int number) {
		List<Integer> numbers = new ArrayList<>();
		
		int digits = (int) (Math.log10(number) + 1);

		for (int i = 0; i < digits; i++) {
			numbers.add(number / (int) Math.pow(10, digits - i - 1) % 10);
		}		
		
		return numbers;
	}

	
}
