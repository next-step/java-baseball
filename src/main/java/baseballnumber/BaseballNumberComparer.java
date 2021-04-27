package baseballnumber;

public class BaseballNumberComparer {
	private final BaseballNumber baseballMachineNumber;
	private final BaseballNumber baseballPlayerNumber;

	public BaseballNumberComparer(int machineNumbers, int playerNumbers) {
		if (isNotValidNumber(machineNumbers) || isNotValidNumber(playerNumbers)) {
			throw new IllegalArgumentException("입력한 숫자가 입력 가능한 범위 밖입니다");
		}

		this.baseballMachineNumber = new BaseballNumber(machineNumbers);
		this.baseballPlayerNumber = new BaseballNumber(playerNumbers);
	}

	private boolean isNotValidNumber(int machineNumbers) {
		return machineNumbers < 123 || machineNumbers > 987;
	}

	public BaseballNumberBoard compare() {
		if (!this.baseballMachineNumber.isValid() || !this.baseballPlayerNumber.isValid()) {
			throw new IllegalArgumentException("입력된 값이 정상적이지 않습니다");
		}

		return this.baseballMachineNumber.compare(baseballPlayerNumber);
	}
}
