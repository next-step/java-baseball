package com.precourse.baseball;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class MainTest {

	@Test
	public void testRandomDigitNum(){
		//������ ���� �ٸ� ���� �迭�� ���
		Main mainObj = new Main();
		int[] result = mainObj.getRandomDigitNum();
		
		System.out.print("������ ���� �ٸ� �� ���: ");
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]);
		}
		
		System.out.println("");
	}
	
	@Test
	public void testInputDigitNum(){
		//�Է¹��� ���� �迭�� ���
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
		//�Է¹��� ���� ������ ���� ���Ͽ� ��Ʈ����ũ�� ���� ������ ���Ѵ�.
		Main mainObj = new Main();
		
		assertEquals((char)mainObj.findStrikeBall(new int[]{1,2,3}, 3, 1), 'B');
		assertEquals(mainObj.findStrikeBall(new int[]{1,2,3}, 3, 2), 'S');
		assertEquals(mainObj.findStrikeBall(new int[]{1,2,3}, 5, 2), ' ');
	}
	
	@Test
	public void testPrintBaseBallResult(){
		//�Է¹��� ���� ������ ���� ���Ͽ� ��Ʈ����ũ�� ���� ������ ���Ѵ�.
		Main mainObj = new Main();
		
		mainObj.printBaseBallResult(0, 0); //����
		mainObj.printBaseBallResult(1, 1); //1 ��Ʈ����ũ 1 ��
	}
	
}
