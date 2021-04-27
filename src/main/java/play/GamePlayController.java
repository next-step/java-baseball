package play;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GamePlayController {

	public static void gameProcess() {
		Map<Integer, Integer> inNumMap = new HashMap<Integer, Integer>();
		Set<Integer> inNumSet = new HashSet<>();

		InputNumberProcess.inputWaitingProcess(inNumMap, inNumSet);

	}

	public static void main(String[] args) {
		gameProcess();
	}
}
