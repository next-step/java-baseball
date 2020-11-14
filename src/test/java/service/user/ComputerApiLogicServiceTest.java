package service.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ComputerApiLogicServiceTest {

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
}
