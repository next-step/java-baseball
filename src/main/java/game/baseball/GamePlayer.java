package game.baseball;

import common.models.HintModel;
import common.models.ThreeNumbers;


/**
 * @brief
 * 게임 시작 및 종료
 * @details 게임 시작 및 종료를 서술합니다.
 * @author SUNJU
 * @since 2021. 4. 27.
 * @version 1.0
 * @see
 * <pre>
 *     since          author              description
 *  ===========    =============    ===========================
 *  2021. 4. 26.     SUNJU         최초 생성
 * </pre>

 */
public class GamePlayer {
	
	private GameCore gameCore = new GameCore();
	
	private ThreeNumbers defendNumbers = null; 
	private boolean isFinish = false;
	
	/**
	 * @brief 게임 초기화
	 * @return 랜덤하게 생성된 수비 숫자
	 */
	public ThreeNumbers startGame() {
		defendNumbers = gameCore.makeDefendNumbers();
		isFinish = false;
		return defendNumbers;
	}
	
	/**
	 * @brief Statements
	 * @param attackNumbers 공격 숫자
	 * @return hintModel
	 */
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
