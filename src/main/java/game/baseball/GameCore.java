package game.baseball;

import common.code.HintType;
import common.models.HintModel;

public class GameCore {
	public HintModel checker(int [] attackNumberArr, int [] defendNumberArr) {
		HintModel result = new HintModel();
		
		for(int i=0; i<attackNumberArr.length; i++) {
			HintModel attackResult = attack(attackNumberArr[i], i, defendNumberArr);
			result.setStrikeCount(result.getStrikeCount()+attackResult.getStrikeCount());
			result.setBallCount(result.getBallCount()+attackResult.getBallCount());
		}
		
		return result;
	}
	
	public HintModel attack(int attackNumber, int attackIndex, int[] defendNumberArr) {
		HintModel result = new HintModel();
		for(int i=0; i<defendNumberArr.length; i++) {
			HintType matched = match(attackNumber, attackIndex, defendNumberArr[i], i);
			result.calculateCount(matched);
		}
		
		return result;
	}
	
	private HintType match(int attackNumber, int attackIndex, int defendNumber, int defendIndex) {
		if (attackNumber != defendNumber) {
			return null;
		}
		
		if (attackIndex == defendIndex) {
			return HintType.STRIKE;
		}
		
		return HintType.BALL;
	}
	
}
