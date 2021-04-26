package game.baseball;

import common.models.HintModel;
import common.models.PlayResultModel;
import common.models.ThreeNumbers;

public class GamePlayer {
	
	GameCore gameCore = new GameCore();
	
	private ThreeNumbers defendNumberArr = null; 
	
	public ThreeNumbers startGame() {
		defendNumberArr = gameCore.makeDefendNumber();
		
		return defendNumberArr;
	}
	
	public PlayResultModel playGame(ThreeNumbers attackNumbers) {
		HintModel hintModel = gameCore.attack(attackNumbers, defendNumberArr);
		
		if(hintModel.getStrikeCount() == 3) {
			return new PlayResultModel(true, hintModel.toString());
		}
		
		return new PlayResultModel(false, hintModel.toString());
	}
	
}
