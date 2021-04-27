package game.baseball;

import java.util.ArrayList;
import java.util.Random;

import common.code.HintType;
import common.exception.GameException;
import common.models.HintModel;
import common.models.ThreeNumbers;


/**
 * @brief
 * Core logic of game
 * @details 게임의 core logic을 서술합니다.
 * @author SUNJU
 * @since 2021. 4. 27.
 * @version 1.0
 * @see
 * <pre>
 *     since          author              description
 *  ===========    =============    ===========================
 *  2021. 4. 25.     SUNJU         최초 생성
 * </pre>

 */
public class GameCore {
	
	/**
	 * @brief 게임 공격
	 * @param attackNumbers 사용자가 입력한 공격 숫자
	 * @param defendNumbers 랜덤하게 생성된 수비 숫자
	 * @return
	 */
	public HintModel attack(ThreeNumbers attackNumbers, ThreeNumbers defendNumbers) {
		HintModel result = new HintModel();
		
		for(int i=0; i<ThreeNumbers.NUMBERS_SIZE; i++) {
			HintModel attackResult = checkAttack(attackNumbers.getNumber(i), i, defendNumbers);
			result.setStrikeCount(result.getStrikeCount()+attackResult.getStrikeCount());
			result.setBallCount(result.getBallCount()+attackResult.getBallCount());
		}
		
		return result;
	}
	
	/**
	 * @brief strike or ball 확인 및 개수 계산
	 * @param attackNumber 공격 숫자 중 1자리 수
	 * @param attackIndex 공격 숫자 중 몇번째 자리 index
	 * @param defendNumbers 랜덤하게 생성된 수비 숫자
	 * @return
	 */
	public HintModel checkAttack(int attackNumber, int attackIndex, ThreeNumbers defendNumbers) {
		HintModel result = new HintModel();
		for(int i=0; i<ThreeNumbers.NUMBERS_SIZE; i++) {
			HintType matched = checkStrikeOrBall(attackNumber, attackIndex, defendNumbers.getNumber(i), i);
			result.calculateCount(matched);
		}
		
		return result;
	}
	
	/**
	 * @brief strike or ball 확인
	 * @param attackNumber 공격 숫자 중 1자리 수
	 * @param attackIndex 공격 숫자 중 몇번째 자리 index
	 * @param defendNumber 수비 숫자 중 1자리 수
	 * @param defendIndex 수비 숫자 중 몇번째 자리 index
	 * @return
	 */
	private HintType checkStrikeOrBall(int attackNumber, int attackIndex, int defendNumber, int defendIndex) {
		if (attackNumber != defendNumber) {
			return null;
		}
		
		if (attackIndex == defendIndex) {
			return HintType.STRIKE;
		}
		
		return HintType.BALL;
	}
	
	/**
	 * @brief 수비를 할 3자리 숫자를 랜덤하게 생성
	 * @return defendNumbers 랜덤하게 생성된 수비 숫자
	 * @throws GameException
	 */
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
