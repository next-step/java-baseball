package com.baseball.precourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 김윤제
 *
 */
public class BaseBallGame extends Thread {
	private boolean runflag = true;
	private Computer computer = new Computer();
	private Player player = new Player();
	private static final int MAX_STRIKE = 3;
	private static final int START_STRIKE = 0;
	private static final int MAX_SIZE = 3;
	private static final int START_BALL = 0;

	@Override
	public void run() {
		while (runflag) {
			playBaseBall();
		}
	}
	
	/**
	 *  게임 시작 
	 * @return void 게임 시작 기능
	 */
	public void playBaseBall() {
		List<Integer> computerNums = computer.getRandomNums();
		int strike = START_STRIKE;
		while (strike < MAX_STRIKE) {
			String input = inputNumByPlayer();
			strike = judgmentPoint(computerNums, input);
		}
		requestStopBaseBall();
	}
	
	/**
	 *  플레이어가 숫자를 입력하게 하며 
	 *  입력한 문자가 숫자인지, 3자리인지, 서로 다른 임의의 수인지 확인하는기능.
	 * @return String 플레이어가 숫자를 입력하게 하는 기능
	 */
	public String inputNumByPlayer() {
		String input = player.selectNums();
		while (!checkSelectedNums(input)) {
			input = player.selectNums();
		}
		return input;
	}
	
	/**
	 *  플레이어가 입력한 수에 대해서
	 *  입력한 문자가 숫자인지, 3자리인지, 서로 다른 임의의 수인지 확인하는기능.
	 * @return boolean 유효성 체크
	 */
	public boolean checkSelectedNums(String inputNum) {
		if (!isNumber(inputNum) && !checkNumLength(inputNum)) {
			return false;
		}
		if (!checkDuplicateNum(inputNum.toCharArray()) ) {
			return false;
		}
		return true;
	}
	
	public boolean isNumber(String inputNum) {
		try {
			Integer.parseInt(inputNum);
		}
		catch (Exception e) {
			printErrorLog();
			return false;
		}
		return true;
	}
	
	public boolean checkNumLength(String inputNum) {
		if ( inputNum.length() != MAX_SIZE ) {
			printErrorLog();
			return false;
		}
		return true;
	}
	
	public boolean checkDuplicateNum(char[] inputNumArray) {
		List<Character> duplicateList = new ArrayList<>(MAX_SIZE);
		for ( char one : inputNumArray ) {
			duplicateList = processDuplicateNum(duplicateList, one);
		}
		if ( duplicateList.size() != MAX_SIZE ) {
			printErrorLog();
			return false;
		}
		return true;
	}
	
	public List<Character> processDuplicateNum(List<Character> duplicateList, char oneNum) {
		if ( !duplicateList.contains(oneNum) ) {
			duplicateList.add(oneNum);
		}
		return duplicateList;
	}

	public int judgmentPoint(List<Integer> computerNums, String playerNums) {
		int strike = 0;
		int ball = 0;
		for ( int i = 0; i < playerNums.length(); i++ ) {
			ball += checkBallPoint(computerNums, playerNums.charAt(i)-'0', i);
			strike += checkStrikePoint(computerNums, playerNums.charAt(i)-'0', i);
		}
		printJudgement(strike, ball);
		return strike;
	}
	
	public int checkBallPoint(List<Integer> computerNums, int playerNum, int position) {
		int ball = 0;
		if ( computerNums.get(position) != playerNum && computerNums.contains(playerNum) ) {
			ball++;
		}
		return ball;
	}
	
	public int checkStrikePoint(List<Integer> computerNums, int playerNum, int position) {
		int strike = 0;
		if ( computerNums.get(position) == playerNum ) {
			strike++;
		}
		return strike;
	}
	
	public void printErrorLog() {
		System.out.print("서로 다른 3자리의 숫자만 입력이 가능합니다.");
	}
	
	public void printEndLog() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
		System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
	
	public void printJudgement(int strike, int ball) {
		StringBuilder sb = new StringBuilder();
		if ( strike > START_STRIKE && strike < MAX_STRIKE ) {
			sb.append(String.format("%d 스트라이크 ", strike));
		}
		
		if ( ball > START_BALL ) {
			sb.append(String.format("%d 볼 ", ball));
		}
		
		if ( strike == START_STRIKE && ball == START_BALL ) {
			sb.append("낫싱");
		}
		
		System.out.println(sb.toString());
	}
	
	public void requestStopBaseBall() {
		printEndLog();
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if ( input == 2 ) {
			runflag = false;
		}
	}
}
