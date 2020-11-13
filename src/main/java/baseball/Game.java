package baseball;

import java.util.List;
import java.util.Scanner;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class Game {
	private static final String MESSAGE_ENTER_NUMBERS = "숫자를 입력해주세요 : ";

	private Printer printer;
	private Scanner scanner;
	private Converter converter;
	private List<Integer> computerNumbers;

	Game() {
		this.printer = new Printer();
		this.scanner = new Scanner(System.in);
		this.converter = new Converter();
	}

	void start() {
		this.computerNumbers = RandomNumberGenerator.generate();

		while (true) {
			printer.print(MESSAGE_ENTER_NUMBERS);
			String input = scanner.next();
			List<Integer> myNumbers = converter.toNumbers(input);

			printer.print(myNumbers.toString()); // TODO : remove this
			printer.print(computerNumbers.toString()); // TODO : remove this
		}

	}

}
