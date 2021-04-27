package play;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import common.MessagesCommon;

public class InputNumberProcess {

	public static final int MIN_VALUE = 123;
	public static final int MAX_VALUE = 987;
	
	public static void inputWaitingProcess(Map<Integer, Integer> inNumMap, Set<Integer> inNumSet) {
		System.out.print(MessagesCommon.INPUT_MSG);
		
		Scanner scan = new Scanner(System.in);

		while (!scan.hasNextInt()) {
			scan.next();
			System.out.print(MessagesCommon.ERROR_NUM_MSG);
			inputWaitingProcess(inNumMap, inNumSet);
		}
		
		int inputNum = scan.nextInt();

		valueCheckProcess(inputNum, inNumMap, inNumSet);
	}

	public static void valueCheckProcess(int inputNum, Map<Integer, Integer> inNumMap, Set<Integer> inNumSet) {
		numMinCheck(inputNum, inNumMap, inNumSet);
		numMaxCheck(inputNum, inNumMap, inNumSet);
		numOverlapCheck(inputNum, inNumMap, inNumSet);
	}
	
	public static void numMinCheck(int inputNum, Map<Integer, Integer> inNumMap, Set<Integer> inNumSet) {
		if (numMinCheck(inputNum)) {
			System.out.print(MessagesCommon.ERROR_MIN_MSG);
			inputWaitingProcess(inNumMap, inNumSet);
		}
	}

	public static boolean numMinCheck(int inputNum) {
		return inputNum < MIN_VALUE;
	}

	public static void numMaxCheck(int inputNum, Map<Integer, Integer> inNumMap, Set<Integer> inNumSet) {
		if (numMaxCheck(inputNum)) {
			System.out.print(MessagesCommon.ERROR_MAX_MSG);
			inputWaitingProcess(inNumMap, inNumSet);
		}
	}
	
	public static boolean numMaxCheck(int inputNum) {
		return inputNum > MAX_VALUE;
	}

	public static void numOverlapCheck(int inputNum, Map<Integer, Integer> inNumMap, Set<Integer> inNumSet) {
		inNumSet.clear();

		if (inNumSet.size() != 3) {
			System.out.print(MessagesCommon.ERROR_OVERLAP_MSG);
			inputWaitingProcess(inNumMap, inNumSet);
		}
	}
}
