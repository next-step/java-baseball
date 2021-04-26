package com.precourse.baseball;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public final static int DIGIT_COUNT = 3; //3자리 수 
	
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
	}
	
	//1) 1~9까지 서로 다른 수로 이루어진 수를 생성하는 메소드
	public int[] getRandomDigitNum() {
		int digitNum[] = new int[DIGIT_COUNT];
		Random rand = new Random();
		
		for(int i = 0; i < DIGIT_COUNT; i++) {
			 int digit = rand.nextInt(9) + 1;
			 digitNum[i] = digit;
			 
			 if(i==0) { 
				 continue;
			 }
			 
			 if(digitNum[i] == digitNum[i-1]) {
				 i--;
			 }
			 
		}
		
		return digitNum;
	}
	
	// 2) 수를 입력 받아 배열에 넣는다.
		public int[] getInputDigitNum(Scanner scan) {
			int digitNum[] = new int[DIGIT_COUNT]; //사용자가 입력한 숫자를 저장할 배열
			
			System.out.print("숫자를 입력해주세요 : ");
			int inputNum = scan.nextInt(); //사용자로부터 입력받은 숫자		
			
			int j = 0;
			for(int i=DIGIT_COUNT-1; i>=0; i--) {
				digitNum[j] = (int) (inputNum / Math.pow(10, i)); ///j번째 자리 수 구하기
				inputNum = (int) (inputNum - (digitNum[j] * Math.pow(10, i))); //다음 자리수를 구하기 위해 구한 자리 값의 크기만큼 빼주기
				j++;
			}
			
			return digitNum;		
		}

}
