package baseballnumber;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberComparer {
	private final List<BaseballNumberDigit> machineNumbers;
	private final List<BaseballNumberDigit> playerNumbers;

	public BaseballNumberComparer(int machineNumbers,
		int playerNumbers) {
		this.machineNumbers = new ArrayList<>();
		this.playerNumbers = new ArrayList<>();
	}

	public BaseballNumberBoard compare() {
		return new BaseballNumberBoard(3, 0); // FIXME : 추후에 제대로 된 값 계산해서 입력하게 처리 필요
	}
}
