package play;

import java.util.HashMap;
import java.util.Map;

public class CompareProcess {

	public static final int COMPARE_NUM_CNT = 4;
	public static final String STRIKE_CNT = "STRIKE_CNT";
	public static final String BALL_CNT = "BALL_CNT";
	public static final String STRIKE_MSG = " 스트라이크 ";
	public static final String BALL_MSG = " 볼 ";
	public static final String NOTHING_MSG = "낫싱";
	public static final int GAME_END_CNT = 3;

	public static boolean gameProcess(Map<Integer, Integer> ranNumMap, Map<Integer, Integer> inNumMap) {
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		resultMap.put(STRIKE_CNT, 0);
		resultMap.put(BALL_CNT, 0);

		int seatNum = 0;

		Map<Integer, Integer> tmpRanNumMap = setTmpMap(ranNumMap);

		compareProcess(tmpRanNumMap, inNumMap, resultMap, seatNum);

		resultViewPrint(resultMap);

		return resultMap.get(STRIKE_CNT) == GAME_END_CNT;

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

		if (!strikeCheck(ranNumMap, inNumMap, resultMap, seatNum)) {
			ballCheck(ranNumMap, inNumMap, resultMap, seatNum);
		}

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

	public static void ballCheck(Map<Integer, Integer> ranNumMap, Map<Integer, Integer> inNumMap,
		Map<String, Integer> resultMap, int seatNum) {

		Map<Integer, Integer> tmpRanNumMap = setTmpMap(ranNumMap, seatNum);

		for (Integer key : tmpRanNumMap.keySet()) {
			valueResultProcess(valueCompare(tmpRanNumMap.get(key), inNumMap.get(seatNum)),
				ranNumMap, resultMap, key, BALL_CNT);
		}
	}

	public static Map<Integer, Integer> setTmpMap(Map<Integer, Integer> ranNumMap, int seatNum) {
		Map<Integer, Integer> tmpMap = new HashMap<Integer, Integer>();

		for (Integer key : ranNumMap.keySet()) {
			tmpMap.put(key, ranNumMap.get(key));
		}

		tmpMap.remove(seatNum);

		return tmpMap;
	}

	public static void resultViewPrint(Map<String, Integer> resultMap) {
		StringBuilder sb = new StringBuilder();

		if (resultMap.get(STRIKE_CNT) > 0) {
			sb.append(resultMap.get(STRIKE_CNT)).append(STRIKE_MSG);
		}

		if (resultMap.get(BALL_CNT) > 0) {
			sb.append(resultMap.get(BALL_CNT)).append(BALL_MSG);
		}

		if ((resultMap.get(STRIKE_CNT) + resultMap.get(BALL_CNT)) == 0) {
			sb.append(NOTHING_MSG);
		}

		System.out.println(sb.toString());
	}
}