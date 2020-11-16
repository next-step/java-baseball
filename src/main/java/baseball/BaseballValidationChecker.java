package baseball;

public class BaseballValidationChecker {
	public boolean checkRule(String input){
		if(!checkNum(input))
			return false;
		if(!checkLength(input))
			return false;
		if (!checkOverlap(input))
			return false;
		return true;
	}
	private boolean checkNum(String input){
		try {
			Integer.parseInt(input);
		}catch (NumberFormatException e){
			return false;
		}
		return true;
	}
	private boolean checkLength(String input){
		if (input.length() == 3){
			return true;
		}
		return false;
	}
	private boolean checkOverlap(String input){
		char first = input.charAt(0);
		char second =input.charAt(1);
		char third =input.charAt(2);

		if(first != second && second != third && first != third ) {
			return true;
		}
		return false;
	}
}
