package game.baseball;

import common.models.HintModel;
import common.models.PlayResultModel;
import common.models.ThreeNumbers;

public class GamePlayer {
	
	private GameCore gameCore = new GameCore();
	
	private ThreeNumbers defendNumberArr = null; 
	private boolean isFinish = false;
	
	public ThreeNumbers startGame() {
		defendNumberArr = gameCore.makeDefendNumber();
		isFinish = false;
		return defendNumberArr;
	}
	
	public String playGame(ThreeNumbers attackNumbers) {
		HintModel hintModel = gameCore.attack(attackNumbers, defendNumberArr);
		
		if(hintModel.getStrikeCount() == 3) {
			isFinish = true;
		}
		
		return hintModel.toString();
	}
	
	public boolean isFinish() {
		return this.isFinish;
	}
	
}
