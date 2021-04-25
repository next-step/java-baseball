package ttuop.nextstep.baseball;

/**
 * 숫자야구 게임 애플리케이션
 *
 * @author ttuop
 */
public class Application {

	public static void main(String[] args) {
		while (MenuController.process()) {
			Game game = new Game();
			game.play();
		}

		UserInterface.shutdown();
	}

}
