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
			//TODO: 게임진행
			List<Integer> candidates = candidateFactory.getNumbers();
			List<Integer> defenseNumbers = defensingUser.pickNumbers(candidates, Constant.NUM_DIGIT);
			List<Integer> offenseNumbers = offensingUser.pickNumbers(candidates, Constant.NUM_DIGIT);
		} while (InputDispatcher.askContinue());
	}

}
