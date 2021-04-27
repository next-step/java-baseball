package main.baseball;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Baseball {
	
	private static int strike = 0;
	private static int ball = 0;
	private static int DIGIT = 3;
	private static String inputNum;
	private static String answer;
	
	public static void main(String[] args) {
		startGame();	//게임시작 - 랜덤 정답 생성	
	
	}
	
	private static void startGame() {
		
		System.out.println("야구게임을 시작합니다.");
		answer = "";	
		makeAnswer();
	}

	private static void makeAnswer() {
		
		while(answer.length() != DIGIT) {
			answer += makeSingleAnswer();	//랜덤 개별 숫자 생성
		}
		
		inputData();	// 사용자 입력	
	}
	
	private static String makeSingleAnswer() {
		
		int randomNum = (int)(Math.random() * (10));
		String tmp = String.valueOf(randomNum);
		
		if(answer.contains(tmp) || randomNum == 0 ) {
			return "";
		}
		
		return tmp;
	}
	
	private static void inputData() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자을 입력하세요 : ");
		inputNum = sc.nextLine();
		
		checkInt();		//사용자 데이터 숫자 확인
	}
	
	public static void checkInt() {
	    
		try {
	    	Integer.parseInt(inputNum);
	    
		} catch (NumberFormatException e) {
	    	errorMsg("ERR01", "숫자만 입력해주십시오.");
			inputData();	//게임 재시작
	    }
	    
		checkLength();		//사용자 데이터 길이 확인
	}
	
	private static void checkLength() {
		
		int rs = compareLength(inputNum, DIGIT);
		
		if(rs > 0) {
			errorMsg("ERR02", DIGIT +"자리 숫자를 입력해주십시오.");
			inputData();	//게임 재시작
			return;
		}
		
		checkZero();	//사용자 데이터 0 여부 확인
		
	}
	
	public static void checkZero() {
		
		if("0".contains(inputNum)) {
			errorMsg("ERR04", "0은 입력할수 없습니다.");
			inputData();	//게임 재시작
			return;
		}
		
		checkDuplication();	//사용자 데이터 중복 확인
	}

	private static int compareLength(String st, int DIGIT) {
		
		if(st.length() != DIGIT) {
			return 1;
		}
		
		return 0;
	}
	
	private static void checkDuplication() {
		
		int rs = 0;
		
		for(int i=0; i < inputNum.length() -1; i++) {
			String tmp = inputNum.substring(i, i+1);
			String rp = inputNum.replace(tmp, "");
			rs += compareLength(rp, DIGIT-1);
		}
		
		if(rs > 0) {
			errorMsg("ERR03", "중복된 숫자가 존재합니다.");
			inputData();	//게임 재시작
			return;
		}
		
		playBaseball();		//야구 게임 판단 시작
		
	}
	
	private static void playBaseball() {
		
		strike = 0;
		ball = 0;
		
		for(int i=0; i < inputNum.length(); i++) {
			String numTmp = inputNum.substring(i, i+1);
			String answerTmp = answer.substring(i, i+1);
			String answerRp = answer.replace(answerTmp, "");
			checkStrike(numTmp, answerTmp);		//스트라이크 확인
			checkBall(numTmp, answerRp);			//볼 확인
		}
		
		outputResult();	//결과 출력
		
	}
	
	
	private static void checkStrike(String numTmp, String answerTmp) {
		if(numTmp.equals(answerTmp)) {
			strike++;
		}
	}

	private static void checkBall(String numTmp, String answerRp) {
		
		//숫자가 볼 여부 파악
		for(int i=0; i < answerRp.length(); i++) {
			String answerTmp = answerRp.substring(i, i+1);
			checkBall2(numTmp, answerTmp);
		}
		
	}
	
	private static void checkBall2(String tmp, String tmp2) {
		if(tmp.equals(tmp2)) {
			ball++;
		}
	}
	
	private static void errorMsg(String errorCode, String errorMsg) {
		System.out.println("[" + errorCode + "] " + errorMsg);
	}
	
	private static void outputResult() {
		
		String rs = "";
		
		if(strike > 0) { 
			rs = strike + "스트라이크 ";
		}
			
		if(ball > 0) {
			rs += ball  + "볼";
		}
		
		if(strike + ball == 0) {
			rs = "낫싱";
		}
		
		System.out.println(rs);	
		outputFinalResult();		//최종 결과 판단
	}

	private static void outputFinalResult() {
		
		if(strike ==3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			exitGame();	//게임종료
			return;
		}
		
		inputData();	//게임 재시작
	}
	
	private static void exitGame() {
		
		int startAt = 0;

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			startAt = sc.nextInt();

		} catch (InputMismatchException e) {
			errorMsg("ERR01", "숫자만 입력해주십시오.");
			exitGame();		//게임종료
			return;
		}
		
		checkFinish(startAt);		//게임종료 결과
	}
	
	private static void checkFinish(int startAt) {
		
		if(startAt == 1) {
			startGame();
			return;
		}
		
		if(startAt == 2) {
			System.out.println("게임이 종료되었습니다.");
			return;
		}
		
		errorMsg("ERR05", "1또는 2만 입력가능합니다.");
		exitGame();				//게임종료
	}

}
