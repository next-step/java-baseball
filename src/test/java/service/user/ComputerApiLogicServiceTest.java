package service.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.entity.Baseball;

public class ComputerApiLogicServiceTest {
	Baseball baseball = new Baseball();
	
	public char[] makeRandomNumber() {
		char[] randomNumberArr = new char[3];
		
		for(int i=0; i<randomNumberArr.length; i++) {
			randomNumberArr[i] = Character.forDigit((int) (Math.random() * 9 + 1), 10);
			System.out.println("randomNumberArr["+i+"] : " + randomNumberArr[i]);
		}
		assertNotNull(randomNumberArr);
		
		return randomNumberArr;
	}
	
	public boolean duplicateCheckNumber(char[] randomNumberArr) {
		if(randomNumberArr[0] == randomNumberArr[1] || randomNumberArr[0] == randomNumberArr[2] || randomNumberArr[1] == randomNumberArr[2]) {
			System.out.println("중복");
			return false;
		}
		System.out.println("생성");
		return true;
	}
	
	@Test
	public void startGame() {
		boolean flag = false;
		
		while(!flag) {
			flag = duplicateCheckNumber(makeRandomNumber());
		}
	}
	
	@Test
	public void inputNumberCheck() {
		char[] inputNumberArr = {'1','ㄱ','2'};
		boolean flag = true;
		
		for(int i=0; i<3; i++) {
			if(!Character.isDigit(inputNumberArr[i])) {
				flag = false;
				System.out.println("is a Number : "+ flag);
				break;
			}
		}
		
		assertFalse(flag);
	}

	@Test
	public void inputDuplicateCheck() {
		char[] inputNumberArr = {'1','2','2'};
		boolean flag = true;
		
		for(int i=0; i<inputNumberArr.length-1; i++) {
			if(!duplicateCheckNumber(inputNumberArr[i], inputNumberArr[i+1])) {
				flag = false;
				System.out.println("is not a duplicate : "+ flag);
				break;
			}
		}
		
		assertFalse(flag);
	}

	public boolean duplicateCheckNumber(char preNumberArr, char postNumberArr) {
		if(preNumberArr == postNumberArr)
			return false;
		return true;
	}
	
	@Test
	public void giveHint() {
		int ball = 0;
		char[] randomNumberArr = {'2','5','7'};
		char[] inputNumberArr = {'7','2','5'};
		
		for(int i=0; i<3; i++) {
			ball = calcBall(randomNumberArr, inputNumberArr, i);
		}
		
		System.out.println(ball + "볼");
		assertEquals(3, ball);
	}
	
	public int calcBall(char[] randomNumberArr, char[] inputNumberArr, int idx) {
		int j=0;
		while(j<3) {
			if(idx != j && randomNumberArr[idx] == inputNumberArr[j]) {
				baseball.setBall(baseball.getBall()+1);
			}
			j++;
		}
		
		System.out.println("ball:"+baseball.getBall());
		return baseball.getBall();
	}
	
	/**
	 * 게임 참가자로부터 입력받은 문자열을 
	 * char 배열로 변환
	 * @return
	 */
	@Test
	public void makeInputNumberArr() {
		char[] inputNumberArr = new char[3];
		String inputNumberStr = "265";
		String makeNumberStr = "";
		
		for(int i=0; i<inputNumberStr.length(); i++) {
			inputNumberArr[i] = inputNumberStr.charAt(i);
		}
		
		for (char c : inputNumberArr) {
			makeNumberStr += String.valueOf(c);
			System.out.println("입력받은 숫자 : " + c);
		}
		
		assertEquals("265", makeNumberStr);
	}
	
	@Test
	public void calcStrike() {
		Baseball baseball = new Baseball();
		char[] randomNumberArr = {'2','5','7'};
		char[] inputNumberArr = {'2','4','7'};
		
		for(int i=0; i<3; i++) {
			if(randomNumberArr[i] == inputNumberArr[i]) {
				baseball.setStrike(baseball.getStrike()+1);
			}
		}
		
		System.out.println(baseball.getStrike() + " 스트라이크");
		assertEquals(2, baseball.getStrike());
	}
	
	@Test
	public void calcBall() {
		Baseball baseball = new Baseball();
		char[] randomNumberArr = {'2','5','7'};
		char[] inputNumberArr = {'5','7','2'};
		
		int i=0;
		int j=0;
		while(i<3) {
			if(i != j && randomNumberArr[i] == inputNumberArr[j]) {
				System.out.println("볼+1");
				baseball.setBall(baseball.getBall()+1);
			}
			
			j++;
			if(j == 3) {
				i++;
				j=0;
			}
		}
		assertEquals(3, baseball.getBall());
	}
	
	@Test
	public void checkNothing() {
		Baseball baseball = new Baseball();
		String result = "";
		
		if(baseball.getStrike() == 0 && baseball.getBall() == 0)
			result = "낫싱";
		
		assertEquals("낫싱", result);
	}
}
