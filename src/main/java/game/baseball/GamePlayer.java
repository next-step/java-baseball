package game.baseball;

import common.models.HintModel;
import common.models.ThreeNumbers;

public class GamePlayer {
	
	private GameCore gameCore = new GameCore();
	
	private ThreeNumbers defendNumbers = null; 
	private boolean isFinish = false;
	
	public ThreeNumbers startGame() {
		defendNumbers = gameCore.makeDefendNumbers();
		isFinish = false;
		return defendNumbers;
	}
	
	public String playGame(ThreeNumbers attackNumbers) {
		HintModel hintModel = gameCore.attack(attackNumbers, defendNumbers);
		
		if(hintModel.getStrikeCount() == 3) {
			isFinish = true;
		}
		
		return hintModel.toString();
	}
	
	public boolean isFinish() {
		return this.isFinish;
	}
	
}
