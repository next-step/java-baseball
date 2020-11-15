package service.user;

import model.entity.Baseball;

public class ComputerApiLogicService {
	public final static int INPUT_PERMIT_LEGNTH = 3;
	
	Baseball baseball = new Baseball();
	
	public int getStrike() {
		return baseball.getStrike();
	}
	
	public char[] makeRandomNumber() {
		boolean duplicateCheck = false;
		char[] randomNumberArr = new char[INPUT_PERMIT_LEGNTH];
		
		while(!duplicateCheck) {
			for(int i=0; i<randomNumberArr.length; i++) {
				randomNumberArr[i] = Character.forDigit((int) (Math.random() * 9 + 1), 10);
			}
			
			duplicateCheck = duplicateCheckNumber(randomNumberArr);
		}
		
		return randomNumberArr;
	}
	
	public boolean duplicateCheckNumber(char[] numberArr) {
		if(numberArr[0] == numberArr[1] || numberArr[0] == numberArr[2] || numberArr[1] == numberArr[2]) {
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

	/**
	 * 게임 참가자의 입력을 검사하여 도움말 출력
	 * @param inputNumber
	 * @return 
	 */
	public boolean printInputValidCheck(String inputNumber) {
		char[] inputNumberArr = makeInputNumberArr(inputNumber);
		
		if(!inputLenghCheck(inputNumberArr))
			System.out.println("3자리 숫자만 입력이 가능합니다.");
		if(!inputNumberCheck(inputNumberArr))
			System.out.println("숫자만 입력이 가능합니다.");
		if(!duplicateCheckNumber(inputNumberArr))
			System.out.println("중복된 숫자를 입력할 수 없습니다.");
		
		return inputLenghCheck(inputNumberArr) && inputNumberCheck(inputNumberArr) && duplicateCheckNumber(inputNumberArr);
	}
	
	/**
	 * 게임 참가자로부터 입력받은 문자열을
	 * char 배열로 변환
	 * @return
	 */
	public char[] makeInputNumberArr(String inputNumberStr) {
		char[] inputNumberArr = new char[inputNumberStr.length()];
		
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
	
	public String giveHint(char[] randomNumber, String inputNumberStr) {
		int strike = 0;
		int ball = 0;
		String hint = "";
		
		for(int i=0; i<INPUT_PERMIT_LEGNTH; i++) {
			strike = calcStrike(randomNumber, makeInputNumberArr(inputNumberStr), i);
			ball = calcBall(randomNumber, makeInputNumberArr(inputNumberStr), i);
		}
		
		if(ball == 0)
			hint = strike + " 스트라이크";
		if(strike == 0) 
			hint = ball + " 볼";
		if(strike > 0 && ball > 0)
			hint = strike + " 스트라이크 " + ball + " 볼";
		if(checkNothing())
			hint = "낫싱";
		
		return hint;
	}
}
