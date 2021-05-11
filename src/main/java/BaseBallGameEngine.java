public class BaseBallGameEngine {

	public static void main(String[] args) {
		try {
			new BaseBallGameManager().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
