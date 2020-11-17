package vo;

import java.util.List;

public class GameNumber {
	private List<Integer> gameNumberList;

	public GameNumber(List<Integer> gameNumberList) {
		this.gameNumberList = gameNumberList;
	}

	public List<Integer> getGameNumberList() {
		return gameNumberList;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Integer number : this.gameNumberList) {
			stringBuilder.append(number);
		}
		return stringBuilder.toString();
	}
}
