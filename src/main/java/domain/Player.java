package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import vo.BaseballNumber;

public class Player {

	String name;
	Set<BaseballNumber> number;

	public Set<BaseballNumber> getNumber() {
		return number;
	}

	public Integer getNumberAsInteger() {
		StringBuilder numberBuilder = new StringBuilder();

		List<BaseballNumber> numberList = new ArrayList<>(this.number);
		numberList.sort(Comparator.comparingInt(BaseballNumber::getIndex));

		for (BaseballNumber baseballNumber : numberList) {
			numberBuilder.append(baseballNumber.getValue().toString());
		}

		return Integer.parseInt(numberBuilder.toString());
	}

	void setNumber(Set<BaseballNumber> number) {
		this.number = Collections.unmodifiableSet(number);
	}

	public Player(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Player player = (Player)o;

		return name.equals(player.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return "Player{" +
			"name='" + name + '\'' +
			", number=" + this.getNumberAsInteger() +
			'}';
	}
}
