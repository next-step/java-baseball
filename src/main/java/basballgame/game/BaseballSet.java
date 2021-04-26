package basballgame.game;

import java.util.List;

public class BaseballSet {

	private int first, second, third;

	public BaseballSet(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public static BaseballSet from(List<Integer> selectThreeNum){
		int first = selectThreeNum.get(0);
		int second = selectThreeNum.get(1);
		int third = selectThreeNum.get(2);
		return new BaseballSet(first, second, third);
	}

	public static BaseballSet from(String userInputNumber) {
		int first = Integer.parseInt(String.valueOf(userInputNumber.charAt(0)));
		int second = Integer.parseInt(String.valueOf(userInputNumber.charAt(1)));
		int third = Integer.parseInt(String.valueOf(userInputNumber.charAt(2)));
		return new BaseballSet(first, second, third);
	}


	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	public int getThird() {
		return third;
	}
}

