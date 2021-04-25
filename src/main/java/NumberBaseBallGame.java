import java.util.Map;

import service.IInitializer;
import service.impl.Initializer;

public class NumberBaseBallGame {

	private final static IInitializer iInitializer = new Initializer();

	public static void main(String[] args) {
		Map<Integer, Integer> computerNumbers = iInitializer.initComputerNumbers();
	}
}
