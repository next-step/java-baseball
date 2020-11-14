package service.user;


public class ComputerApiLogicService {
	public final static int INPUT_PERMIT_LEGNTH = 3;
	
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
}
