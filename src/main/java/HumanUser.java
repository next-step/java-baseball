import java.util.ArrayList;
import java.util.List;

public class HumanUser implements User {
	private ArrayList<Integer> chosenNumbers;

	public HumanUser(){
		chosenNumbers = new ArrayList<>();
	}

	@Override
	public ArrayList<Integer> pickNumbers(List<Integer> numbers, int numNeedToPick) {
		return null;
	}
}
