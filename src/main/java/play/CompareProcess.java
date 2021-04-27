package play;

import java.util.HashMap;
import java.util.Map;

public class CompareProcess {
	
	public static final int COMPARE_NUM_CNT = 4;
	public static final String STRIKE_CNT = "STRIKE_CNT";

	public static boolean gameProcess(Map<Integer, Integer> ranNumMap, Map<Integer, Integer> inNumMap) {
		Map<String, Integer> resultMap = new HashMap<String, Integer>();

		int seatNum = 0;

		Map<Integer, Integer> tmpRanNumMap = setTmpMap(ranNumMap);

		compareProcess(tmpRanNumMap, inNumMap, resultMap, seatNum);

		return true;

	}

	public static void compareProcess(Map<Integer, Integer> ranNumMap, Map<Integer, Integer> inNumMap,
		Map<String, Integer> resultMap, int seatNum) {
		seatNum++;

		if (compareNumCntConfirm(seatNum)) {
			return;
		}

		middleProceed(ranNumMap, inNumMap, resultMap, seatNum);
	}

	public static boolean compareNumCntConfirm(int seatNum) {
		return seatNum == COMPARE_NUM_CNT;
	}

	public static Map<Integer, Integer> setTmpMap(Map<Integer, Integer> ranNumMap) {
		Map<Integer, Integer> tmpMap = new HashMap<Integer, Integer>();

		for (Integer key : ranNumMap.keySet()) {
			tmpMap.put(key, ranNumMap.get(key));
		}

		return tmpMap;
	}

	public static boolean getValueConfirm(int seatNum, Map<Integer, Integer> ranNumMap) {
		return ranNumMap.get(seatNum) != null;
	}

	public static boolean valueCompare(Integer aVal, Integer bVal) {
		return aVal == bVal;
	}

	public static void valueResultProcess(boolean valResult, Map<Integer, Integer> inNumMap,
		Map<String, Integer> resultMap, int seatNum, String keyNm) {
		if (valResult) {
			inNumMap.remove(seatNum);
			resultMap.put(keyNm, (resultMap.get(keyNm) + 1));
		}
	}

	public static void middleProceed(Map<Integer, Integer> ranNumMap, Map<Integer, Integer> inNumMap,
		Map<String, Integer> resultMap, int seatNum) {

		strikeCheck(ranNumMap, inNumMap, resultMap, seatNum);

		compareProcess(ranNumMap, inNumMap, resultMap, seatNum);
	}

	public static boolean strikeCheck(Map<Integer, Integer> ranNumMap, Map<Integer, Integer> inNumMap,
		Map<String, Integer> resultMap, int seatNum) {
		boolean compareResult = false;

		if (getValueConfirm(seatNum, ranNumMap)) {
			compareResult = valueCompare(ranNumMap.get(seatNum), inNumMap.get(seatNum));
			valueResultProcess(compareResult, ranNumMap, resultMap, seatNum, STRIKE_CNT);
		}

		return compareResult;
	}
}
