import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
	private CandidateFactory candidateFactory;
	private User offensingUser;
	private User defensingUser;

	public BaseballGame(CandidateFactory candidateFactory){
		this.candidateFactory = candidateFactory;
	}

	public void setOffensingUser(User user){
		this.offensingUser = user;
	}

	public void setDefensingUser(User user){
		this.defensingUser = user;
	}

	public void start(){
		List<Integer> candidates = candidateFactory.getNumbers();
		RefereeClient refereeClient = new RefereeClient();
		ArrayList<Integer> defenseNumbers = defensingUser.pickNumbers(candidates, Constant.NUM_DIGIT);
		refereeClient.setDefenseNumbers(defenseNumbers);
		do{
			refereeClient.resetMatchResult();
			ArrayList<Integer> offenseNumbers = offensingUser.pickNumbers(candidates, Constant.NUM_DIGIT);
			refereeClient.setOffenseNumbers(offenseNumbers);
			refereeClient.printMatchResult();
		} while(refereeClient.isGameEnd() == false);
	}
}
