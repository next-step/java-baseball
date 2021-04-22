package baseball;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class BaseballGame {
	public static void main(String[] args) {
		
	}
	
	public static List<Integer> generateRandomIntegerList(int randLength) {
		Random rand = new Random();
		List<Integer> randList = new ArrayList<Integer>();
		for(int i = 0; i < randLength; ++i) {
			Integer randomIntValue = null;
			do {
				randomIntValue = rand.nextInt(8) + 1;
			} while(randList.contains(randomIntValue));
			randList.add(randomIntValue);
		}
		return Collections.unmodifiableList(randList);
 	}
}
