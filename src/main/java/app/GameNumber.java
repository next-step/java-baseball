package app;

import java.util.ArrayList;

public class GameNumber {
	private ArrayList<Integer> gameNumberList;

	public ArrayList<Integer> getGameNumberList() {
		return gameNumberList;
	}

	public void setGameNumberList(ArrayList<Integer> gameNumberList) {
		this.gameNumberList = gameNumberList;
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
