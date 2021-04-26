import java.util.Scanner;

public class BaseballGameUI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		boolean isContinue = true;

		BaseballGameLogic baseballGameLogic = new BaseballGameLogic();
		baseballGameLogic.makeNumber();

		while (isContinue) {
			System.out.print("숫자를입력해주세요 : ");
			input = scanner.nextLine();
		}
	}
}
