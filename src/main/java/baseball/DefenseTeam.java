package baseball;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefenseTeam {
	private String defenseNumbers;

	public void prepareDefenseNumbers() {
		Game.printMessage("숫자를 입력해주세요 : ");
		String input = Game.receiveUserInput();

		Pattern pattern = Pattern.compile("\\d{3}");
		Matcher matcher = pattern.matcher(input);
		if (!matcher.matches()) {
			Game.printMessage("3자리 숫자만 입력할 수 있습니다.");
			this.prepareDefenseNumbers();
			return;
		}

		this.defenseNumbers = input;
	}

	public String getDefenseNumbers() {
		return this.defenseNumbers;
	}
}
