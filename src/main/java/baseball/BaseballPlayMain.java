package baseball;

public class BaseballPlayMain {

	public static void main(String[] args) {
		Baseball game = null;
		
		boolean gameStauts = true;
		while(gameStauts) {
			game = new BaseballPlay();
			gameStauts = game.run();
		};

	}

}
