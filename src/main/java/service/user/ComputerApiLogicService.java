package service.user;

import model.entity.Baseball;
import model.entity.Player;

public class ComputerApiLogicService {
	public final static int INPUT_PERMIT_LEGNTH = 3;
	
	Baseball baseball = new Baseball();
	Player player = new Player();
	
	public char[] makeRandomNumber() {
		char[] randomNumberArr = new char[INPUT_PERMIT_LEGNTH];
		for(int i=0; i<randomNumberArr.length; i++) {
			randomNumberArr[i] = Character.forDigit((int) (Math.random() * 9 + 1), 10);
		}
		return randomNumberArr;
	}
	
	public boolean duplicateCheckRandomNumber(char[] randomNumberArr) {
		if(randomNumberArr[0] == randomNumberArr[1] || randomNumberArr[0] == randomNumberArr[2] || randomNumberArr[1] == randomNumberArr[2]) {
			return false;
		}
		return true;
	}
	
	public boolean inputLenghCheck(char[] inputNumberArr) {
		if(inputNumberArr.length > INPUT_PERMIT_LEGNTH || inputNumberArr.length < INPUT_PERMIT_LEGNTH) {
			return false;
		}
		return true;
	}

	public boolean inputNumberCheck(char[] inputNumberArr) {
		boolean flag = true;
		for(int i=0; i<inputNumberArr.length; i++) {
			if(!Character.isDigit(inputNumberArr[i])) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public boolean inputDuplicateCheck(char[] inputNumberArr) {
		boolean flag = true;
		for(int i=0; i<inputNumberArr.length-1; i++) {
			if(!duplicateCheckNumber(inputNumberArr[i], inputNumberArr[i+1])) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public boolean duplicateCheckNumber(char preNumberArr, char postNumberArr) {
		if(preNumberArr == postNumberArr)
			return false;
		return true;
	}

	/**
	 * 게임 참가자의 입력을 검사하여 도움말 출력
	 * @param inpuNumberArr
	 * @return 
	 */
	public boolean printInputValidCheck(char[] inputNumberArr) {
		if(!inputLenghCheck(inputNumberArr))
			System.out.println("3자리 숫자만 입력이 가능합니다.");
		if(!inputNumberCheck(inputNumberArr))
			System.out.println("숫자만 입력이 가능합니다.");
		if(!inputDuplicateCheck(inputNumberArr))
			System.out.println("중복된 숫자를 입력할 수 없습니다.");
		
		return inputLenghCheck(inputNumberArr) && inputNumberCheck(inputNumberArr) && inputDuplicateCheck(inputNumberArr);
	}
	
	public String giveHint() {
		int strike = 0;
		int ball = 0;
		
		for(int i=0; i<INPUT_PERMIT_LEGNTH; i++) {
			strike = calcStrike(makeRandomNumber(), makeInputNumberArr(), i);
			ball = calcBall(makeRandomNumber(), makeInputNumberArr(), i);
		}
		
		if(checkNothing())
			return "낫싱";
		return strike + "스트라이크, " + ball + "볼 입니다.";
	}
	
	/**
	 * 게임 참가자로부터 입력받은 문자열을 
	 * char 배열로 변환
	 * @return
	 */
	public char[] makeInputNumberArr() {
		char[] inputNumberArr = new char[INPUT_PERMIT_LEGNTH]; 
		String inputNumberStr = player.getInputNumber();
		
		for(int i=0; i<inputNumberStr.length(); i++) {
			inputNumberArr[i] = inputNumberStr.charAt(i);
		}
		
		return inputNumberArr;
	}
	
	public int calcStrike(char[] randomNumberArr, char[] inputNumberArr, int idx) {
		if(randomNumberArr[idx] == inputNumberArr[idx]) {
			baseball.setStrike(baseball.getStrike()+1);
		}
		
		return baseball.getStrike();
	}
	
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
	
	public boolean checkNothing() {
		if(baseball.getStrike() == 0 && baseball.getBall() == 0)
			return true;
		return false;
	}
}
