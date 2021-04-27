package play;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GamePlayController {


	public static void gameProcess() {
		Map<Integer, Integer> inNumMap = new HashMap<Integer, Integer>();
		Set<Integer> inNumSet = new HashSet<>();
		Map<Integer, Integer> ranNumMap = new HashMap<Integer, Integer>();

		RandomNumProcess.setRandomNum(ranNumMap);

		boolean whileYn = false;

		repeatProcess(inNumMap, inNumSet, ranNumMap, whileYn);
		
	}

	public static void repeatProcess(Map<Integer, Integer> inNumMap, Set<Integer> inNumSet,
		Map<Integer, Integer> ranNumMap, boolean whileYn) {

		if (whileYn) {
			return;
		}

		InputNumberProcess.inputWaitingProcess(inNumMap, inNumSet);
		whileYn = CompareProcess.gameProcess(ranNumMap, inNumMap);

		inNumSet.clear();

		repeatProcess(inNumMap, inNumSet, ranNumMap, whileYn);
	}


	public static void main(String[] args) {
		gameProcess();
	}
}