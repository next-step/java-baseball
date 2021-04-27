package baseball;

public class PrintMessage {

	public static void PrintRequestNumberMessage() {
		System.out.print("숫자를 입력해주세요 : ");
	}
	
	public static void PrintResultMessage(MatchChecker matchChecker) {
		String message = "";
		if (matchChecker.getStrike() == 0 && matchChecker.getBall() == 0) {
			message = "낫씽";
		}
		
		if (matchChecker.getStrike() > 0) {
			message = matchChecker.getStrike() + " 스트라이크" + " ";
		} 
		
		if (matchChecker.getBall() > 0) {
			message += matchChecker.getBall() + " 볼";
		} 
		System.out.println(message);
	}
	
	public static void PrintWinMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
	
	public static void PrintRestartMessage() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
	
}
