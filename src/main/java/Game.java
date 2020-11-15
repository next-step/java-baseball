
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Game {
	private static String START_MESSAGE = "게임을 시작합니다.";
	
	private List<Integer> targetNumber;
	
	public void playRound() {
		System.out.println(START_MESSAGE);

		generateTargetNumber();
		
		System.out.println(targetNumber);
	}
	
	private void generateTargetNumber() {
		Set<Integer> numbers = getTargetNumberSet();
		
		targetNumber = new ArrayList<Integer>();
		for (int number : numbers) {
			targetNumber.add(number);
		}
	}
	
	public Set<Integer> getTargetNumberSet() {
		Set<Integer> numbers = new LinkedHashSet<>();
		
		while (numbers.size() < 3) {
			numbers.add((int)(Math.random() * 9) + 1);
		}
		
		return numbers;	
	}

}