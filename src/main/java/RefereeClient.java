import java.util.ArrayList;
import java.util.HashMap;

public class RefereeClient {
	private HashMap<BaseballResultType, Integer> matchResult;
	private ArrayList<Integer> defenseNumbers;
	private ArrayList<Integer> offenseNumbers;

	public RefereeClient(){
		this.resetMatchResult();
	}

	public void setDefenseNumbers(ArrayList<Integer> defenseNumbers) {
		this.defenseNumbers = defenseNumbers;
	}

	public void setOffenseNumbers(ArrayList<Integer> offenseNumbers){
		this.offenseNumbers = offenseNumbers;
		judgeAllNumbers();
	}

	private void judgeAllNumbers(){
		resetMatchResult();
		for (Integer offenseNumber: offenseNumbers) {
			addMatchResultCountByType(judgeOneNumber(offenseNumber));
		}
	}

	private BaseballResultType judgeOneNumber(Integer offenseNumber){
		if(defenseNumbers.contains(offenseNumber)){
			return isStrikeOrBall(offenseNumber);
		}
		return BaseballResultType.NO_COUNT;
	}

	private BaseballResultType isStrikeOrBall(Integer offenseNumber){
		int offenseNumberIdx = offenseNumbers.indexOf(offenseNumber);
		if(offenseNumber.equals(defenseNumbers.get(offenseNumberIdx))){
			return BaseballResultType.STRIKE;
		}
		return BaseballResultType.BALL;
	}

	private void addMatchResultCountByType(BaseballResultType baseballResultType){
		matchResult.put(baseballResultType, matchResult.get(baseballResultType) + 1);
	}

	public void printMatchResult(){
		this.matchResult.forEach((matchResultType, matchResultCount)->{
			System.out.print(getResultStatement(matchResultType, matchResultCount));
		});
	}

	private String getResultStatement(BaseballResultType baseballResultType, Integer count){
		if(baseballResultType.equals(BaseballResultType.STRIKE)){
			return count.toString() + " " + "스트라이크\n";
		}
		if(baseballResultType.equals(BaseballResultType.BALL)){
			return count.toString() + " " + "볼\n";
		}
		return "";
	}

	public boolean isGameEnd() {
		if(matchResult.get(BaseballResultType.STRIKE).equals(Constant.NUM_GAMEEND_CONDITION)){
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}

	public void resetMatchResult() {
		this.matchResult = new HashMap<BaseballResultType, Integer>(){{
			put(BaseballResultType.STRIKE, 0);
			put(BaseballResultType.BALL, 0);
			put(BaseballResultType.NO_COUNT, 0);
		}};
	}
}
