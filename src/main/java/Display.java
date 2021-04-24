import java.util.Map;
import java.util.Scanner;

public class Display {
	private final Scanner scanner = new Scanner(System.in);
	private final String[] messages = {
		"숫자를 입력해주세요",
		"3개의 숫자를 모두 맞히셨습니다! 게임 종료",
		"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.",
		"낫싱",
		"스트라이크",
		"볼"
	};

	public String input() {
		return scanner.nextLine().trim();
	}

	public void print() {
		System.out.printf("%s : ", messages[0]);
	}

	public void print(Map<Result, Integer> resultMap) {
		if (resultMap.getOrDefault(Result.STRIKE, -1) == 3) {
			System.out.printf("%s\n%s\n", messages[1], messages[2]);
			return;
		}

		if (resultMap.getOrDefault(Result.NONE, -1) == 3) {
			System.out.printf("%s\n", messages[3]);
			return;
		}

		System.out.println(getResultMapString(resultMap));
	}

	private String getResultMapString(Map<Result, Integer> resultMap) {
		StringBuilder sb = new StringBuilder();

		resultMap.forEach((result, count) -> {
			sb.append(resultToString(result, count));
		});

		return sb.toString().trim();
	}

	private String resultToString(Result result, Integer count) {
		if (result == Result.STRIKE) {
			return String.format("%d %s ", count, messages[4]);
		}

		if (result == Result.BALL) {
			return String.format("%d %s ", count, messages[5]);
		}

		return "";
	}
}
