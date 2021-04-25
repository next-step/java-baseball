package game.baseball;

import java.util.ArrayList;
import java.util.Random;

import common.code.HintType;
import common.models.HintModel;

public class GameCore {
	
	private final int DEFEND_COUNT = 3; 
	
	public HintModel attack(int [] attackNumberArr, int [] defendNumberArr) {
		HintModel result = new HintModel();
		
		for(int i=0; i<attackNumberArr.length; i++) {
			HintModel attackResult = checkAttack(attackNumberArr[i], i, defendNumberArr);
			result.setStrikeCount(result.getStrikeCount()+attackResult.getStrikeCount());
			result.setBallCount(result.getBallCount()+attackResult.getBallCount());
		}
		
		return result;
	}
	
	public HintModel checkAttack(int attackNumber, int attackIndex, int[] defendNumberArr) {
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
	
	public int[] makeDefendNumber() {
			
		ArrayList<Integer> targets = new ArrayList<Integer>();
		for(int i=0; i<9; i++) {
			targets.add(i+1);
		}
		long seed = System.currentTimeMillis();
		Random random = new Random(seed);
		
		int[] result = new int[DEFEND_COUNT];
		for(int i=0; i<DEFEND_COUNT; i++) {
			result[i] = targets.remove(random.nextInt(targets.size()-1));
		}
		
		return result;
			
	}
	
}
