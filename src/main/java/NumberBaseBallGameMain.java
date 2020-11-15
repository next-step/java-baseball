import java.util.Scanner;

public class NumberBaseBallGameMain {

	private NumberBaseBall numberBaseBall = new NumberBaseBall();

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		NumberBaseBallGameMain numberBaseBallGameMain = new NumberBaseBallGameMain();
		String restart = "1";

		while (restart.equals("1")) {
			numberBaseBallGameMain.play();
			restart = sc.next();
		}
	}

	public void play() {
		String answerNumber = numberBaseBall.makeRandomNumberString();
		String inputNumber = "";

		while (isWrong(answerNumber, inputNumber)) {
			inputNumber = this.printStartMessageAndGetInput();
			System.out.println(numberBaseBall.calculate(answerNumber, inputNumber));
		}

		printAnswerMessage();
	}

	private void printAnswerMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	private boolean isWrong(String answerNumber, String inputNumber) {
		return !answerNumber.equals(inputNumber);
	}

	private String printStartMessageAndGetInput() {
		System.out.print("숫자를 입력해주세요: ");
		String inputNumber = sc.next();
		return inputNumber;
	}
}
