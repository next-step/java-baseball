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
}
