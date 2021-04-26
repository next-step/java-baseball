package com.precourse.baseball;

import java.util.Random;

public class Main {
	
	public final static int DIGIT_COUNT = 3; //3자리 수 
	
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

}
