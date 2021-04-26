package baseball;

public class Player {
	private Number number;

	public Player() {
	}

	public Number getNumber() {
		return number;
	}

	public void setNumber(Number number) {
		this.number = number;
	}

	public boolean hasNumber() {
		if (number == null) {
			return false;
		}
		return true;
	}
}
