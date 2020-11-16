package app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Baseball {
	public GameNumber createRandomGameNumber() {
		GameNumber randomGameNumber = new GameNumber();
		Random random = new Random();
		Set<Integer> numberSet = new HashSet<>();
		while (numberSet.size() < Constants.GAME_NUMBER_LENGTH) {
			numberSet.add(random.nextInt(Constants.MAX_NUMBER) + 1);
		}
		randomGameNumber.setGameNumberList(new ArrayList<>(numberSet));
		return randomGameNumber;
	}
}
