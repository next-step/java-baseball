import java.util.Scanner;

public class InputDispatcher {

	public static boolean askContinue(){
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			String gameContinueInput = scan.nextLine();
			if (gameContinueInput.equals(Constant.CONTINUE)) {
				return true;
			}
			if (gameContinueInput.equals(Constant.EXIT)) {
				return false;
			}
		}
	}

	public static String askUserExpect(){
		System.out.print("숫자를 입력해주세요 : ");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		return userInput;
	}
}
