import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BaseballGame {
	private final int numnCreateCnt = 3;
	BaseballGame(){
		
	}
	
	public static void main(String[] args) {
		BaseballGame bg = new BaseballGame();
		bg.startBaseballGame();
	}

	public void startBaseballGame() {
		String rNumStr = createRandomNum();
		userGameStart(rNumStr);
	}
	
	public String createRandomNum() {
		Set<Integer> distinctNumSet = new LinkedHashSet<>();
		while(distinctNumSet.size() < numnCreateCnt) {
			distinctNumSet.add(new Random().nextInt(9) + 1);
		}
		return convertSetToStr(distinctNumSet);
	}
	
	public String convertSetToStr(Set<Integer> distinctNumSet) {
		StringBuilder returnStrBd = new StringBuilder();
		for (Integer num : distinctNumSet) {
			returnStrBd.append(num.toString());
		}
		return returnStrBd.toString();
	}
	
	public void userGameStart(String rNumStr) {
		String userInputStr = inputGameNumber();
		System.out.println(userInputStr);
	}
	
	public String inputGameNumber() {
		System.out.println("숫자를 입력해주세요 : ");
		String inputStr = new Scanner(System.in).next();
		if (!validateGameNum(inputStr)) {
			return inputGameNumber();
		}
		return inputStr;
	}
	
	public boolean validateGameNum(String inputStr) {
		if (checkPatternNum(inputStr)) {
			Set<Character> distinctCharSet = convertNumSet(inputStr);
			if (inputStr.length() == distinctCharSet.size()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkPatternNum(String inputStr) {
		Pattern numPattern = Pattern.compile("([1-9]{3})");
		Matcher matcher = numPattern.matcher(inputStr);
		return matcher.matches();
	}
	
	public Set<Character> convertNumSet(String inputStr){
		Set<Character> distinctCharSet = new LinkedHashSet<>();
		for (char a : inputStr.toCharArray()) {
			distinctCharSet.add(a);
		}
		return distinctCharSet;
	}
}
