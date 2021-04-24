package input;

import java.util.List;
import java.util.Scanner;

import config.Property;
import type.Message;

public class InputService {

	private final Scanner scanner;
	private final ParseService parseService;

	public InputService(ParseService parseService) {
		this.scanner = new Scanner(System.in);
		this.parseService = parseService;
	}

	public List<Integer> nextIntegerList(String printString, int size) {
		try {
			System.out.println(printString);
			return parseService.parse(scanner.nextLine(), size);
		} catch (IllegalArgumentException ex) {
			System.out.println(Message.RETRY_INPUT);
			return nextIntegerList(printString, size);
		}
	}

	public int nextGameStatusTypeFlag(String printString) {
		try {
			System.out.println(printString);
			return parseService.parse(scanner.nextLine(), Property.TYPE_FLAG_LENGTH).get(0);
		} catch (IllegalArgumentException ex) {
			System.out.println(Message.RETRY_INPUT);
			return nextGameStatusTypeFlag(printString);
		}
	}
}
