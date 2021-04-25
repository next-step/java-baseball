import java.util.ArrayList;
import java.util.List;

public class CandidateFactory {
	private GameConfig gameConfig;

	public CandidateFactory(GameConfig gameConfig){
		this.gameConfig = gameConfig;
	}

	public List<Integer> getNumbers(){
		List<Integer> numbers = new ArrayList<>();
		for (Integer i=gameConfig.getMinOptionNum(); i<gameConfig.getMaxOptionNum()+1; i++) {
			numbers.add(i);
		}
		return numbers;
	}
}
