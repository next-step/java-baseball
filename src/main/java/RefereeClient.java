import java.util.ArrayList;
import java.util.HashMap;

public class RefereeClient {
	private HashMap<BaseballResult, Integer> matchResult;
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
		for (Integer offenseNumber: offenseNumbers) {
			addMatchResultCountByType(judgeOneNumber(offenseNumber));
		}
	}

	private BaseballResult judgeOneNumber(Integer offenseNumber){
		if(defenseNumbers.contains(offenseNumber)){
			return isStrikeOrBall(offenseNumber);
		}
		return BaseballResult.NO_COUNT;
	}

	private BaseballResult isStrikeOrBall(Integer offenseNumber){
		int offenseNumberIdx = offenseNumbers.indexOf(offenseNumber);
		if(offenseNumber.equals(defenseNumbers.get(offenseNumberIdx))){
			return BaseballResult.STRIKE;
		}
		return BaseballResult.BALL;
	}

	private void addMatchResultCountByType(BaseballResult baseballResult){
		matchResult.put(baseballResult, matchResult.get(baseballResult) + 1);
	}

	public void printMatchResult(){
		this.matchResult.forEach((matchResultType, matchResultCount)->{
			System.out.print(getResultStatement(matchResultType, matchResultCount));
		});
	}

	private String getResultStatement(BaseballResult baseballResult, Integer count){
		if(baseballResult.equals(BaseballResult.STRIKE)){
			return count.toString() + " " + "스트라이크\n";
		}
		if(baseballResult.equals(BaseballResult.BALL)){
			return count.toString() + " " + "볼\n";
		}
		return "";
	}

	public boolean isGameEnd() {
		if(matchResult.get(BaseballResult.STRIKE).equals(Constant.NUM_GAMEEND_CONDITION)){
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}

	public void resetMatchResult() {
		this.matchResult = new HashMap<BaseballResult, Integer>(){{
			put(BaseballResult.STRIKE, 0);
			put(BaseballResult.BALL, 0);
			put(BaseballResult.NO_COUNT, 0);
		}};
	}
}
