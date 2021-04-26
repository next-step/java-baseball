import ui.exception.GamePlayException;

public class BaseBallGame {

	public static void main(String[] args){
		try {
			new BaseBallGameManager().run();
		} catch (GamePlayException ex){
			System.out.println(ex.getMessage());
		}
	}
}
