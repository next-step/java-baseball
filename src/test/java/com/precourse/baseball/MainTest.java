package com.precourse.baseball;

import java.util.Scanner;

import org.junit.Test;

public class MainTest {

	@Test
	public void testRandomDigitNum(){
		//랜덤한 서로 다른 수를 배열로 출력
		Main mainObj = new Main();
		int[] result = mainObj.getRandomDigitNum();
		
		System.out.print("랜덤한 서로 다른 수 출력: ");
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]);
		}
		
		System.out.println("");
	}
	
	@Test
	public void testInputDigitNum(){
		//입력받은 수를 배열로 출력
		Main mainObj = new Main();
		Scanner scan = new Scanner(System.in);
		int[] result = mainObj.getInputDigitNum(scan);
		
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]);
		}
		
		System.out.println("");
	}
}
