package baseball.state;

import java.util.List;
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

		if (!Converter.isNumber(raw)) {
			return true;
		}

		if (Converter.toNumber(raw) < 100) {
			return true;
		}

		guess(raw);
		return true;
	}

	public void guess(String raw) {
		List<Integer> numbers = Converter.toList(Converter.toNumber(raw));
		game.createPlayer(numbers);
		game.onDecisionState();
	}

	private String pitch() {
		System.out.println("\n세자리 숫자를 입력하세요:");
		return scanner.nextLine();
	}

	private void alert() {
		System.out.println("세자리 숫자가 아닙니다.");
	}
}
