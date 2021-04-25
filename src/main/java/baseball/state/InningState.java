package baseball.state;

import java.util.Scanner;

import baseball.Converter;
import baseball.Game;

public class InningState implements State {

	private Scanner scanner = new Scanner(System.in);
	private Converter converter = new Converter();
	private Game game;

	public InningState(Game game) {
		this.game = game;
	}

	@Override
	public boolean action() {
		String raw = pitch();

		if (isThreeDigits(raw)) {
			guess(raw);
		}
		return true;
	}

	public void guess(String raw) {
		game.getPlayer().setNumbers(converter.toArray(converter.toNumber(raw)));
		game.setState(game.getDecisionState());
	}

	public boolean isThreeDigits(String raw) {
		if (converter.isThreeDigits(raw)) {
			return true;
		}
		alert();
		return false;
	}

	private String pitch() {
		System.out.println("\n세자리 숫자를 입력하세요:");
		return scanner.nextLine();
	}

	private void alert() {
		System.out.println("세자리 숫자가 아닙니다.");
	}
}
