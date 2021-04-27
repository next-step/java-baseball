package baseball.domain;

import java.io.IOException;
import java.util.List;

import baseball.utils.Converter;
import baseball.utils.RandomGenerator;
import baseball.utils.Validation;
import baseball.view.InputReader;
import baseball.view.PrintMessage;

public class Game {

	public final static int NUMBER_LENGTH = 3;
	public List<Integer> answer;

	public void start() throws IOException {
		RandomGenerator generator = new RandomGenerator();
		answer = generator.makeRandomNumbers();
		play();
	}

	private void play() throws IOException {
		Player player = new Player();
		do {
			String InputStr = InputReader.getInput();
			if (Validation.checkInputNumber(InputStr)) {
			}
		} while (!player.isFinished());
	}

}
