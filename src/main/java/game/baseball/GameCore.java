package game.baseball;

import java.util.ArrayList;
import java.util.Random;

import common.code.HintType;
import common.exception.GameException;
import common.models.HintModel;
import common.models.ThreeNumbers;

public class GameCore {
	
	public HintModel attack(ThreeNumbers attackNumbers, ThreeNumbers defendNumbers) {
		HintModel result = new HintModel();
		
		for(int i=0; i<ThreeNumbers.NUMBERS_SIZE; i++) {
			HintModel attackResult = checkAttack(attackNumbers.getNumber(i), i, defendNumbers);
			result.setStrikeCount(result.getStrikeCount()+attackResult.getStrikeCount());
			result.setBallCount(result.getBallCount()+attackResult.getBallCount());
		}
		
		return result;
	}
	
	public HintModel checkAttack(int attackNumber, int attackIndex, ThreeNumbers defendNumbers) {
		HintModel result = new HintModel();
		for(int i=0; i<ThreeNumbers.NUMBERS_SIZE; i++) {
			HintType matched = checkStrikeOrBall(attackNumber, attackIndex, defendNumbers.getNumber(i), i);
			result.calculateCount(matched);
		}
		
		return result;
	}
	
	private HintType checkStrikeOrBall(int attackNumber, int attackIndex, int defendNumber, int defendIndex) {
		if (attackNumber != defendNumber) {
			return null;
		}
		
		if (attackIndex == defendIndex) {
			return HintType.STRIKE;
		}
		
		return HintType.BALL;
	}
	
	public ThreeNumbers makeDefendNumbers() throws GameException {
		ArrayList<Integer> targets = new ArrayList<Integer>();
		for(int i=0; i<9; i++) {
			targets.add(i+1);
		}
		
		Random random = new Random(System.currentTimeMillis());
		int numbers = 0;
		for(int i=2; i>=0; i--) {
			numbers += targets.remove(random.nextInt(targets.size()-1))*Math.pow(10, i);
		}
		
		return new ThreeNumbers(numbers);
	}
	
}
