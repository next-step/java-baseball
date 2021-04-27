package play;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import common.MessagesCommon;

public class GamePlayController {

	public static final int COMPARE_NUM_CNT = 4;
	public static final int REPLAY_NUM = 1;
	public static final int GAME_END_NUM = 2;

	public static void gameProcess() {
		Map<Integer, Integer> inNumMap = new HashMap<Integer, Integer>();
		Set<Integer> inNumSet = new HashSet<>();
		Map<Integer, Integer> ranNumMap = new HashMap<Integer, Integer>();

		RandomNumProcess.setRandomNum(ranNumMap);

		boolean whileYn = false;

		repeatProcess(inNumMap, inNumSet, ranNumMap, whileYn);
		
		System.out.println(MessagesCommon.GAME_END_MSG);
		System.out.println(MessagesCommon.GAME_REPLAY_MSG);
		
		if (backToTheGame()) {
			gameProcess();
		}
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

	public static boolean backToTheGame() {

		Scanner scan = new Scanner(System.in);

		while (!scan.hasNextInt()) {
			scan.next();
			System.out.print(MessagesCommon.ERROR_NUM_MSG);
			backToTheGame();
		}

		int inputNum = scan.nextInt();

		if(REPLAY_NUM != inputNum && GAME_END_NUM != inputNum){
			System.out.print(MessagesCommon.GAME_REPLAY_MSG);
			backToTheGame();
		}
		
		return replayCheck(inputNum);
	}
	
	public static boolean replayCheck(int inputNum){
		boolean check = false;
		
		if(GAME_END_NUM == inputNum){
			check = false;
		}
		
		if(REPLAY_NUM == inputNum){
			check = true;
		}
		
		return check;
	}

	public static void main(String[] args) {
		gameProcess();
	}
}