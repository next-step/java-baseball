import java.util.ArrayList;
import java.util.List;

public class HumanUser implements User {
	private ArrayList<Integer> chosenNumbers;

	public HumanUser(){
		chosenNumbers = new ArrayList<>();
	}

	@Override
	public ArrayList<Integer> pickNumbers(List<Integer> numbers, int numNeedToPick) {
		String userExpect = UserInterface.askUserExpect();
		setChosenNumbers(parseNumericString(userExpect));
		return this.chosenNumbers;
	}

	public ArrayList<Integer> parseNumericString(String numericString){
		ArrayList<Integer> parsedResult = new ArrayList<>();
		for(int i=0; i<numericString.length(); i++){
			parsedResult.add( Character.getNumericValue(numericString.charAt(i)) );
		}
		return parsedResult;
	}

	public void setChosenNumbers(ArrayList<Integer> chosenNumbers){
		this.chosenNumbers = chosenNumbers;
	}
}
