package common.models;

import common.code.HintType;

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
	
	@Override
	public String toString() {
		StringBuilder resultMessage = new StringBuilder();
		
		if(strikeCount>0) {
			resultMessage.append(HintType.STRIKE.getHintValue()+strikeCount+"개 ");
		}
		if(ballCount>0) {
			resultMessage.append(HintType.BALL.getHintValue()+ballCount+"개");
		}
		
		return resultMessage.toString();
	}
}
