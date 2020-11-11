package woo.baseball.domain;

public class GameUser {
	private final static int baseBallNumberSize = 3;
	private int baseBallNumber;
	private String[] strNumber = new String[baseBallNumberSize];

	public int getBaseBallNumber() {
		return baseBallNumber;
	}

	public void setBaseBallNumber(int baseBallNumber) {
		this.baseBallNumber = baseBallNumber;
	}

	public String[] getStrNumber() {
		return strNumber;
	}

	public void setStrNumber(String[] strNumber) {
		this.strNumber = strNumber;
	}

	public static int getBaseballnumbersize() {
		return baseBallNumberSize;
	}

}
