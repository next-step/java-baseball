package service.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.entity.Baseball;

public class ComputerApiLogicServiceTest {
	Baseball baseball = new Baseball();

	@DisplayName("랜덤 숫자 생성")
	public char[] makeRandomNumber() {
		char[] randomNumberArr = new char[3];
		
		for(int i=0; i<randomNumberArr.length; i++) {
			randomNumberArr[i] = Character.forDigit((int) (Math.random() * 9 + 1), 10);
			System.out.println("randomNumberArr["+i+"] : " + randomNumberArr[i]);
		}
		assertNotNull(randomNumberArr);
		
		return randomNumberArr;
	}
	
	@DisplayName("숫자 중복 입력 확인")
	public boolean duplicateCheckNumber(char[] numberArr) {
		if(numberArr[0] == numberArr[1] || numberArr[0] == numberArr[2] || numberArr[1] == numberArr[2]) {
			return false;
		}
		return true;
	}
	
	@Test
	@DisplayName("중복 숫자에 대한 로직 확인")
	public void startGame() {
		boolean flag = false;
		
		while(!flag) {
			flag = duplicateCheckNumber(makeRandomNumber());
		}
	}
	
	@Test
	@DisplayName("숫자 아닌 문자 확인")
	public void inputNumberCheck() {
		char[] inputNumberArr = {'1','ㄱ','2'};
		boolean flag = true;
		
		for(int i=0; i<3; i++) {
			if(!Character.isDigit(inputNumberArr[i])) {
				flag = false;
				break;
			}
		}
		
		assertFalse(flag);
	}
	
	@Test
	@DisplayName("랜덤 숫자와 입력한 숫자 비교 후 볼 확인")
	public void giveHint() {
		int ball = 0;
		char[] randomNumberArr = {'2','5','7'};
		char[] inputNumberArr = {'7','2','5'};
		
		for(int i=0; i<3; i++) {
			ball = calcBall(randomNumberArr, inputNumberArr, i);
		}
		
		assertEquals(3, ball);
	}
	
	@DisplayName("랜덤 숫자와 입력한 숫자 비교 후 볼 확인, 로직 테스트")
	public int calcBall(char[] randomNumberArr, char[] inputNumberArr, int idx) {
		int j=0;
		while(j<3) {
			if(idx != j && randomNumberArr[idx] == inputNumberArr[j]) {
				baseball.setBall(baseball.getBall()+1);
			}
			j++;
		}
		
		return baseball.getBall();
	}
	
	@Test
	@DisplayName("랜덤 숫자와 입력한 숫자 비교 후 스트라이크 수 확인")
	public void calcStrike() {
		Baseball baseball = new Baseball();
		char[] randomNumberArr = {'2','5','7'};
		char[] inputNumberArr = {'2','4','7'};
		
		for(int i=0; i<3; i++) {
			if(randomNumberArr[i] == inputNumberArr[i]) {
				baseball.setStrike(baseball.getStrike()+1);
			}
		}
		
		assertEquals(2, baseball.getStrike());
	}
	
	@Test
	@DisplayName("랜덤 숫자와 입력한 숫자 비교 후 낫싱 확인")
	public void checkNothing() {
		Baseball baseball = new Baseball();
		String result = "";
		
		if(baseball.getStrike() == 0 && baseball.getBall() == 0)
			result = "낫싱";
		
		assertEquals("낫싱", result);
	}
	
	@Test
	@DisplayName("게임 참가자로부터 입력받은 문자열을 char로 변환")
	public void makeInputNumberArr() {
		char[] inputNumberArr = new char[3];
		String inputNumberStr = "265";
		String makeNumberStr = "";
		
		for(int i=0; i<inputNumberStr.length(); i++) {
			inputNumberArr[i] = inputNumberStr.charAt(i);
		}
		
		for (char c : inputNumberArr) {
			makeNumberStr += String.valueOf(c);
		}
		
		assertEquals("265", makeNumberStr);
	}
}
