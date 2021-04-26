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
		
	}

}
