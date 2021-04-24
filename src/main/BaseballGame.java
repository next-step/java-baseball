package srdc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseballGame {
	BaseballGame(){
		
	}
	
	String rNumStr = "";
	String userInputStr = "";
	Map<String, Integer> returnMap = new HashMap<>();
	
//	public static void main(String[] args) {
//		BaseballGame bg = new BaseballGame();
//		bg.gameStart();
//	}
	
	gameStart();

	public void gameStart() {
		rNumStr = createRandomNum();
		userGameStart();
	}
	
	public void userGameStart() {
		userInputStr = inputGameNumber();
		System.out.println(userInputStr); //test
		returnMap = compareNums(rNumStr, userInputStr);
		if (actGameResult(returnMap)) {
			gameReStart();
			return;
		}
		userGameStart();
	}
	
	public void gameReStart() {
		if (inputGameRestart()) {
			gameStart();
		}
	}
	
	public boolean inputGameRestart() {
		System.out.println("restart!");
		String inputStr = new Scanner(System.in).next();
		if ("1".equals(inputStr)) {
			return true;
		}
		if ("2".equals(inputStr)) {
			return false;
		}
		return inputGameRestart();
	}
	
	public boolean actGameResult(Map<String, Integer> returnMap) {
		if (returnMap.getOrDefault("N", 0) == 3) {
			System.out.println("Nothing");
			return false;
		}
		printGameResultMap(returnMap);
		if (returnMap.getOrDefault("S", 0) == 3) {
			return true;
		}
		return false;
	}
	
	public void printGameResultMap(Map<String, Integer> returnMap) {
		StringBuilder printStrBd = new StringBuilder();
		for (String key : returnMap.keySet()) {
			if ("N".equals(key)) {
				continue;
			}
			printStrBd.append(returnMap.get(key) + " " + key + " ");
		}
		System.out.println(printStrBd.toString());
	}
	
	public String createRandomNum() {
		Set<Integer> distinctNumSet = new LinkedHashSet<>();
		while(distinctNumSet.size() < 3) {
			distinctNumSet.add(new Random().nextInt(9) + 1);
		}
		return toString(distinctNumSet);
	}
	
	public String toString(Set<Integer> distinctNumSet) {
		StringBuilder returnStrBd = new StringBuilder();
		for (Integer num : distinctNumSet) {
			returnStrBd.append(num.toString());
		}
		return returnStrBd.toString();
	}
	
	public String inputGameNumber() {
		System.out.println("input:");
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
	
	public HashMap<String, Integer> compareNums(String rNum, String uNum){
		Map<String, Integer> returnMap = new HashMap<>();
		char[] uNumChar = uNum.toCharArray();
		for (int i = 0; i < uNumChar.length; i++) {
			String resStr = getResultChar(rNum.indexOf(uNumChar[i]), i);
			int cnt = returnMap.getOrDefault(resStr, 0);
			returnMap.put(resStr, cnt + 1);
		}
		System.out.println(returnMap);
		return (HashMap<String, Integer>) returnMap;
	}
	
	public String getResultChar(int rIndex, int uIndex) {
		if(rIndex == uIndex) {
			return "S";
		}
		if(rIndex > -1) {
			return "B";
		}
		return "N";
	}
	
}
