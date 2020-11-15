package domain;

import java.util.HashSet;
import java.util.Set;

import vo.BaseballNumber;

public class User extends Player {

	public void changeNumber(Integer number) {
		this.changeNumber(number.toString());
	}

	public void changeNumber(String number) {
		String[] numberArray = number.split("");
		Set<BaseballNumber> numberSet = new HashSet<>(numberArray.length);
		for (int index = 0; index < numberArray.length; index++) {
			numberSet.add(new BaseballNumber(Integer.parseInt(numberArray[index]), index));
		}
		this.setNumber(numberSet);
	}

}
