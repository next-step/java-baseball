package baseball.state;

import java.util.List;

import baseball.Converter;
import baseball.Game;
import baseball.io.Display;
import baseball.io.Keyboard;

public class InningState implements State {

	private Game game;

	public InningState(Game game) {
		this.game = game;
	}

	@Override
	public boolean action() {
		Display.pitch();
		String raw = Keyboard.read();
		if (isThreeDigits(raw)) {
			guess(raw);
		}
		return true;
	}

	public boolean isThreeDigits(String raw) {
		if (raw.length() == 3 && Converter.isNumber(raw) && Converter.toNumber(raw) > 99) {
			return true;
		}
		Display.notThreeDigits();
		return false;
	}

	public void guess(String raw) {
		List<Integer> numbers = Converter.toList(Converter.toNumber(raw));
		game.createPlayer(numbers);
		game.onDecisionState();
	}

}
