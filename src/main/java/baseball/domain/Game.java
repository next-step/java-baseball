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
		PrintMessage.printStart();
		play();
	}

	private void play() throws IOException {
		Player player = new Player();
		do {
			PrintMessage.printAskNumber();
			String InputStr = InputReader.getInput();
			if (Validation.checkInputNumber(InputStr)) {
				List<Integer> input = Converter.convertStringToIntegerList(InputStr, "");
				player.calculate(answer, input);
				PrintMessage.printResult(player.getResult());
			}
		} while (!player.isFinished());
	}

}
