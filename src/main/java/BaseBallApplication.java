public class BaseBallApplication {
	public static void main(String[] args) {
		int[] userInputNumbers = BaseBallGame.getUserInputNumbers();
		for (int a : userInputNumbers) {
			System.out.print(a);
		}
	}
}