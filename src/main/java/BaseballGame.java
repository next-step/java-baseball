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
		do {
			List<Integer> candidates = candidateFactory.getNumbers();
			ArrayList<Integer> defenseNumbers = defensingUser.pickNumbers(candidates, Constant.NUM_DIGIT);
			ArrayList<Integer> offenseNumbers = offensingUser.pickNumbers(candidates, Constant.NUM_DIGIT);
			//TODO: 결과 판단
		} while (InputDispatcher.askContinue());
	}
}
