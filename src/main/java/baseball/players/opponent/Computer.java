package baseball.players.opponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Computer implements Opponent {
	private final int HIDDEN_NUMBER_COUNT = 3;
	private final List<Integer> NUMBER_BOX = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	private List<Integer> hiddenNumber;

	public Computer() {
		this.hiddenNumber = generateHiddenNumber();
	}

	public Computer(List<Integer> hiddenNumber) {
		this.hiddenNumber = hiddenNumber;
	}

	private List<Integer> generateHiddenNumber() {
		Collections.shuffle(NUMBER_BOX);
		return NUMBER_BOX.subList(0, HIDDEN_NUMBER_COUNT);
	}

	@Override
	public List<Integer> getHiddenNumbers() {
		return new ArrayList<>(hiddenNumber);
	}

	@Override
	public void reset() {
		this.hiddenNumber = generateHiddenNumber();
	}
}
