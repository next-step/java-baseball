package common.models;

import java.util.ArrayList;
import java.util.List;

import common.code.HintType;


/**
 * @brief
 * HintModel
 * @details HintModel을 서술합니다.
 * @author SUNJU
 * @since 2021. 4. 25.
 * @version 1.0
 * @see
 * <pre>
 *     since          author              description
 *  ===========    =============    ===========================
 *  2021. 4. 27.     SUNJU         최초 생성
 * </pre>

 */
public class HintModel {

	private int strikeCount = 0;
	private int ballCount = 0;
	
	public int getStrikeCount() {
		return strikeCount;
	}
	public void setStrikeCount(int strikeCount) {
		this.strikeCount = strikeCount;
	}
	public int getBallCount() {
		return ballCount;
	}
	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}
	
	//hintType에 따른 카운팅
	public void calculateCount(HintType hintType) {
		if (hintType == null) {
			return;
		}
		
		if(hintType.equals(HintType.STRIKE)) {
			this.strikeCount++;
		}
		
		if(hintType.equals(HintType.BALL)) {
			this.ballCount++;
		}
	}
	
	//결과 출력
	@Override
	public String toString() {
		if(strikeCount+ballCount==0) {
			return HintType.NOTHING.getHintValue();
		}
		
		return makeStrikeBallMessage();
	}
	
	private String makeStrikeBallMessage() {
		List<String> resultMessageArr = new ArrayList<String>();
		
		if(strikeCount>0) {
			resultMessageArr.add(HintType.STRIKE.getHintValue()+strikeCount+"개");
		}
		if(ballCount>0) {
			resultMessageArr.add(HintType.BALL.getHintValue()+ballCount+"개");
		}
		
		return String.join(" ", resultMessageArr);
	}
}
