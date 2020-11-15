import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NumberBaseBall {
	private static final List<String> NUMBERS =
		Collections.unmodifiableList(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

	private static final int NUMBERS_MAX_INDEX = 8;

	public String makeRandomNumberString() {
		String numberString = "";
		List<String> tempNumbers = new ArrayList(NUMBERS);

		Random random = new Random();
		for(int i = 0; i < 3; i++) {
			int randomIdx = random.nextInt(NUMBERS_MAX_INDEX - i);
			numberString += tempNumbers.get(randomIdx);
			tempNumbers.remove(randomIdx);
		}
		return numberString;
	}
}
