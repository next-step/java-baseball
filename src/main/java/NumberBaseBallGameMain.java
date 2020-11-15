import java.util.Scanner;

public class NumberBaseBallGameMain {

	public static void main(String[] args) {
		NumberBaseBallGameMain numberBaseBallGameMain = new NumberBaseBallGameMain();
		numberBaseBallGameMain.play();
	}

	public void play() {
		String inputNumber = this.printMessageAndGetInput();
		System.out.println("입력한 값: " + inputNumber);
	}

	public String printMessageAndGetInput() {
		System.out.print("숫자를 입력해주세요: ");
		Scanner sc = new Scanner(System.in);
		String inputNumber = sc.next();
		return inputNumber;
	}
}
