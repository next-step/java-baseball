package domain;

import java.util.Collections;
import java.util.Set;

import vo.BaseballNumber;

public class Player {

	Set<BaseballNumber> number;

	public Set<BaseballNumber> getNumber() {
		return number;
	}

	void setNumber(Set<BaseballNumber> number) {
		this.number = Collections.unmodifiableSet(number);
	}

}
