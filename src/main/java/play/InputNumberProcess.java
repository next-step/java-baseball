package play;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import common.MessagesCommon;

public class InputNumberProcess {
	
	public static void inputWaitingProcess(Map<Integer, Integer> inNumMap, Set<Integer> inNumSet) {
		System.out.print(MessagesCommon.INPUT_MSG);
		
		Scanner scan = new Scanner(System.in);

		while (!scan.hasNextInt()) {
			scan.next();
			System.out.print(MessagesCommon.ERROR_NUM_MSG);
			inputWaitingProcess(inNumMap, inNumSet);
		}
		
		int inputNum = scan.nextInt();

	}
}
