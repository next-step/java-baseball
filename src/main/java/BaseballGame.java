public class BaseballGame {
	private GameConfig gameConfig;
	private boolean willContinue = false;

	public BaseballGame(GameConfig gameConfig){
		this.gameConfig = gameConfig;
	}

	public void start(){
		do {
			//TODO: 게임진행
			setWillContinue(InputDispatcher.askContinue());
		} while (getWillContinue());
	}

	public void setWillContinue(boolean willContinue) {
		this.willContinue = willContinue;
	}

	public boolean getWillContinue(){
		return this.willContinue;
	}
}
