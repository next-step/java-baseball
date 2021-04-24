import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BaseballGame {
	private final int numCreateCnt = 3;
	public enum Status{
		S("스트라이크"),
		B("볼");
		
		private String status; 
		
		Status(String status){
			this.status = status;
		}
		
		public static String findStatus(String arg) {
			for(Status st : Status.values()) {
				if(st.name().equals(arg)) {
					return st.status;
				}
			}
			return "";
		}
		
	}
	
	BaseballGame(){
		
	}
	
	public static void main(String[] args) {
		BaseballGame bg = new BaseballGame();
		bg.startBaseballGame();
	}

	public void startBaseballGame() {
		String rNumStr = createRandomNum();
		startUserGame(rNumStr);
	}
	
	public String createRandomNum() {
		Set<Integer> distinctNumSet = new LinkedHashSet<>();
		while(distinctNumSet.size() < numCreateCnt) {
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
	
	public void startUserGame(String rNumStr) {
		String userInputStr = inputGameNumber();
		Map<String, Integer> returnMap = compareNums(rNumStr, userInputStr);
		if (actGameResult(returnMap)) {
			restartBaseballGame();
			return;
		}
		startUserGame(rNumStr);
	}
	
	public void restartBaseballGame() {
		if ("1".equals(inputGameRestart())) {
			startBaseballGame();
		}
	}
	
	public String inputGameRestart() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		String inputStr = new Scanner(System.in).next();
		if ("1".equals(inputStr) || "2".equals(inputStr)) {
			return inputStr;
		}
		return inputGameRestart();
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
		Pattern numPattern = Pattern.compile("([1-9]{"+numCreateCnt+"})");
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
	
	public boolean actGameResult(Map<String, Integer> returnMap) {
		if (returnMap.getOrDefault("N", 0) == numCreateCnt) {
			System.out.println("낫싱");
			return false;
		}
		printGameResultMap(returnMap);
		if (returnMap.getOrDefault("S", 0) == numCreateCnt) {
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
			printStrBd.append(returnMap.get(key) + Status.findStatus(key) + " ");
		}
		System.out.println(printStrBd.toString());
	}	
}
