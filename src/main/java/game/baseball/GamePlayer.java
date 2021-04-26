package game.baseball;

import common.models.HintModel;
import common.models.PlayResultModel;

public class GamePlayer {
	
	GameCore gameCore = new GameCore();
	
	private int[] defendNumberArr = null; 
	
	public int[] startGame() {
		defendNumberArr = gameCore.makeDefendNumber();
		
		return defendNumberArr;
	}
	
	public PlayResultModel playGame(int[] attackNumberArr) {
		HintModel hintModel = gameCore.attack(attackNumberArr, defendNumberArr);
		
		if(hintModel.getStrikeCount() == 3) {
			return new PlayResultModel(true, hintModel.toString());
		}
		
		return new PlayResultModel(false, hintModel.toString());
	}
	
}
