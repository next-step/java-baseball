import java.util.ArrayList;
import java.util.List;

public class ComputerUser implements User {
	private ArrayList<Integer> chosenNumbers;

	public ComputerUser(){
		chosenNumbers = new ArrayList<>();
	}

	@Override
	public ArrayList<Integer> pickNumbers(List<Integer> candidates, int numNeedToPick) {
		for (int i = 0; i< Constant.NUM_DIGIT; i++) {
			int curRandomIndex = (int) ((Math.random() * ((candidates.size()-1))));
			chosenNumbers.add(candidates.get(curRandomIndex));
			candidates.remove(curRandomIndex);
		}
		return chosenNumbers;
	}
}
