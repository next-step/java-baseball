package game;

import ui.InputManager;
import ui.OutputManager;
import ui.PrintOutputManager;
import ui.ScannerInputManager;

public class EndState implements GameState {

	private final InputManager inputManager = ScannerInputManager.getInstance();
	private final OutputManager outputManager = PrintOutputManager.getInstance();
	
	private static GameState gameState = new EndState();

	private EndState() {
	}

	public static GameState getInstance() {
		return gameState;
	}

	@Override
	public void next(Game game) {		
		outputManager.print(game.getComputer().getNumbers().size() + "개의 숫자를 모두 맞히셨습니다!게임 종료\n");
		outputManager.print("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.\n");
		
		int input = inputManager.nextInt();
		
		if(input == 1) {
			game.setGameState(InitState.getInstance());
			game.progress();
			
			return;
		} 
		
		if(input == 2) {
			game.end();
			
			return;
		}
		
		game.setGameState(EndState.getInstance());
		game.progress();
	}

}
