package com.nextstep.baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static String autoNum = ""; //컴퓨터가 선택한 3개의 숫자
	public static String ballNum = ""; //사용자 입력한 3개의 숫자
	public static int strikeCnt = 0; //스트라이크 카운트
	public static int ballCnt = 0; //볼 카운트
	
	
	public static void main(String[] args) {
		//컴퓨터가 선택한 3개의 숫자 생성 메서드 & 최초 실행
		autoNumCreate();
	}
	
	//1~9 사이의 중복되지 않는 랜덤한 3개의 숫자 생성 메서드
	public static void autoNumCreate() {
		autoNum = "";
		List<Integer> numList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		
		Collections.shuffle(numList);
	    StringBuilder sb = new StringBuilder(3);
	    for (Integer num : numList.subList(0, 3)) {
	        sb.append(num);
	    }

	    autoNum = sb.toString();
	    
	    inputNum();//사용자 입력 메서드
	}
	
	//문자열 입력 메서드
	public static void inputNum() {
		ballNum = "";
		System.out.print("숫자를 입력해주세요 : ");
		Scanner sc = new Scanner(System.in);
		ballNum = sc.next();
		
		numRuleCheck();
	}
	
	//입력 숫자 규칙 확인
	public static void numRuleCheck(){
		boolean isCheckRule = ValidationCheck.checkRule(ballNum);
		
		if(!isCheckRule){//정해진 규칙에 맞지 않으면 새로 입력받도록 호출
			System.out.println("정해진 규칙에 맞지 않은 숫자입니다.");
			inputNum();
		}
		compareNum();
	}
	
	public static void compareNum(){
		String arrAutoNum[] = autoNum.split("");//숫자를 배열로 리턴
		String arrBallNum[] = ballNum.split("");//숫자를 배열로 리턴
		
		strikeCnt = BallCount.strikeCheck(arrAutoNum, arrBallNum);//스트라이크 카운트 함수
		if(strikeCnt == 3){
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			finalCheck();
		}
		ballCnt = BallCount.ballCheck(arrAutoNum, arrBallNum);//볼 카운트 함수
		printCompareNum(strikeCnt, ballCnt);
	}
	
	public static void printCompareNum(int strikeCnt, int ballCnt){
		MessagePrint.printMessage(strikeCnt, ballCnt);
		inputNum();
	}
	
	//마지막 종료 체크 함수
		public static void finalCheck(){
			System.out.println("게임을 새로 시작하려면1, 종료하려면 2을 입력하세요.");
			Scanner sc = new Scanner(System.in);
			String finalNum  = sc.next();
			finalNumCheck(finalNum);
			
			if(finalNum.equals("1")){
				autoNumCreate();
			}
			System.exit(0);
		}
		
		//게임 종료 질문 답 체크 함수
		public static void finalNumCheck(String finalNum){
			if(!finalNum.equals("1") && !finalNum.equals("2")){
				finalCheck();
			}
		}
	
}
