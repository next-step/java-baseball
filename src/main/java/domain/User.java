package domain;

public class User extends Player {

	public void changeNumber(Integer number) {
		this.setNumber(number);
	}

	public void changeNumber(String number) {
		this.setNumber(Integer.parseInt(number));
	}

}
