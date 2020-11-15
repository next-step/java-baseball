package baseball.player;

import java.util.ArrayList;
import java.util.List;

public class User implements Player {
	private final List<String> number = new ArrayList<>();

	@Override
	public void setNumber(String input) {
		number.add(input);
	}

	@Override
	public String getNumber() {
		return number.get(number.size() - 1);
	}
}
