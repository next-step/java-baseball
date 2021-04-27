package com.precourse.baseball;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class MainTest {

	//@Test
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
	
	//@Test
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
	
	@Test
	public void testFindStrikeBall(){
		//입력받은 수와 생성한 수를 비교하여 스트라이크와 볼의 개수를 구한다.
		Main mainObj = new Main();
		
		assertEquals((char)mainObj.findStrikeBall(new int[]{1,2,3}, 3, 1), 'B');
		assertEquals(mainObj.findStrikeBall(new int[]{1,2,3}, 3, 2), 'S');
		assertEquals(mainObj.findStrikeBall(new int[]{1,2,3}, 5, 2), ' ');
	}
	
}
