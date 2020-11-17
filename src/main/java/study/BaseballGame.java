package study;

import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class BaseballGame {
	private final BaseballRandomValueGenerator generator = new BaseballRandomValueGenerator();

	private int strikeCount = 0;

	private int ballCount = 0;

	public void referee(List<Integer> numbers) {
		this.strikeCount = this.count(numbers, (value, index) -> {
			List<Integer> randomValue = generator.getValue();
			return randomValue.contains(value) && randomValue.indexOf(value) == index;
		});

		this.ballCount = this.count(numbers, (value, index) -> {
			List<Integer> randomValue = generator.getValue();
			return randomValue.contains(value) && randomValue.indexOf(value) != index;
		});
	}

	private int count(List<Integer> numbers, BiPredicate<Integer, Integer> predicate) {
		int count = 0;
		for (int index = 0, len = numbers.size(); index < len; index++) {
			int value = numbers.get(index);
			if (predicate.test(value, index)) {
				count++;
			}
		}
		return count;
	}

	public String getMessage() {
		if (this.strikeCount < 1 && this.ballCount < 1) {
			return "낫싱";
		}

		StringBuilder buffer = new StringBuilder();
		if (this.strikeCount > 0) {
			buffer.append(String.format("%d 스트라이크 ", this.strikeCount));
		}

		if (this.ballCount > 0) {
			buffer.append(String.format("%d 볼 ", this.ballCount));
		}

		return buffer.toString();
	}

	public void start() {
		do {
			System.out.print("3자리 숫자를 입력해주세요 : ");
			List<Integer> numbers = this.scanner();
			this.reset();
			this.referee(numbers);
			this.print();
		} while (this.isGameEnd());
	}

	private List<Integer> scanner() {
		List<Integer> numbers;
		try {
			Scanner scanner = new Scanner(System.in);
			int input = scanner.nextInt();
			numbers = BaseballUtil.toList(input);
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다. 중복이 없는 3자리 숫자를 입력해주세요. 예) 398");
			return scanner();
		}
		return numbers;
	}

	private void reset() {
		this.strikeCount = 0;
		this.ballCount = 0;
	}

	private boolean isGameEnd() {
		return this.strikeCount != 3;
	}

	private void print() {
		System.out.println(this.getMessage());
	}
}
