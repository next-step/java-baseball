package basballgame.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseballSetGenerator {

	private static final List<Integer> NUM_SET = Arrays.asList(1,2,3,4,5,6,7,8,9);

	public static BaseballSet generate() {
		Collections.shuffle(NUM_SET);
		List<Integer> selectThreeNum = NUM_SET.subList(0,3);
		return BaseballSet.from(selectThreeNum);
	}
}
