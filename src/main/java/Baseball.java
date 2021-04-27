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
		startGame();	//���ӽ��� - ���� ���� ����	
	
	}
	
	private static void startGame() {
		
		System.out.println("�߱������� �����մϴ�.");
		answer = "";	
		makeAnswer();
	}

	private static void makeAnswer() {
		
		while(answer.length() != DIGIT) {
			answer += makeSingleAnswer();	//���� ���� ���� ����
		}
		
		inputData();	// ����� �Է�	
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
		System.out.print("������ �Է��ϼ��� : ");
		inputNum = sc.nextLine();
		
		checkInt();		//����� ������ ���� Ȯ��
	}
	
	public static void checkInt() {
	    
		try {
	    	Integer.parseInt(inputNum);
	    
		} catch (NumberFormatException e) {
	    	errorMsg("ERR01", "���ڸ� �Է����ֽʽÿ�.");
			inputData();	//���� �����
	    }
	    
		checkLength();		//����� ������ ���� Ȯ��
	}
	
	private static void checkLength() {
		
		int rs = compareLength(inputNum, DIGIT);
		
		if(rs > 0) {
			errorMsg("ERR02", DIGIT +"�ڸ� ���ڸ� �Է����ֽʽÿ�.");
			inputData();	//���� �����
			return;
		}
		
		checkZero();	//����� ������ 0 ���� Ȯ��
		
	}
	
	public static void checkZero() {
		
		if("0".contains(inputNum)) {
			errorMsg("ERR04", "0�� �Է��Ҽ� �����ϴ�.");
			inputData();	//���� �����
			return;
		}
		
		checkDuplication();	//����� ������ �ߺ� Ȯ��
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
			errorMsg("ERR03", "�ߺ��� ���ڰ� �����մϴ�.");
			inputData();	//���� �����
			return;
		}
		
		playBaseball();		//�߱� ���� �Ǵ� ����
		
	}
	
	private static void playBaseball() {
		
		strike = 0;
		ball = 0;
		
		for(int i=0; i < inputNum.length(); i++) {
			String numTmp = inputNum.substring(i, i+1);
			String answerTmp = answer.substring(i, i+1);
			String answerRp = answer.replace(answerTmp, "");
			checkStrike(numTmp, answerTmp);		//��Ʈ����ũ Ȯ��
			checkBall(numTmp, answerRp);			//�� Ȯ��
		}
		
		outputResult();	//��� ���
		
	}
	
	
	private static void checkStrike(String numTmp, String answerTmp) {
		if(numTmp.equals(answerTmp)) {
			strike++;
		}
	}

	private static void checkBall(String numTmp, String answerRp) {
		
		//���ڰ� �� ���� �ľ�
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
			rs = strike + "��Ʈ����ũ ";
		}
			
		if(ball > 0) {
			rs += ball  + "��";
		}
		
		if(strike + ball == 0) {
			rs = "����";
		}
		
		System.out.println(rs);	
		outputFinalResult();		//���� ��� �Ǵ�
	}

	private static void outputFinalResult() {
		
		if(strike ==3) {
			System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ��������");
			exitGame();	//��������
			return;
		}
		
		inputData();	//���� �����
	}
	
	private static void exitGame() {
		
		int startAt = 0;

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
			startAt = sc.nextInt();

		} catch (InputMismatchException e) {
			errorMsg("ERR01", "���ڸ� �Է����ֽʽÿ�.");
			exitGame();		//��������
			return;
		}
		
		checkFinish(startAt);		//�������� ���
	}
	
	private static void checkFinish(int startAt) {
		
		if(startAt == 1) {
			startGame();
			return;
		}
		
		if(startAt == 2) {
			System.out.println("������ ����Ǿ����ϴ�.");
			return;
		}
		
		errorMsg("ERR05", "1�Ǵ� 2�� �Է°����մϴ�.");
		exitGame();				//��������
	}

}
