package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Baseball {

    public static Integer makeRandomNumber () throws Exception {
    	
    	String randomString = "";
    	while (randomString.length() < FULL_COUNT_NUMBER) {
    		Random random = new Random(); //랜덤 객체 생성(디폴트 시드값 : 현재시간)
        	random.setSeed(System.currentTimeMillis()); //시드값 설정을 따로 할수도 있음
        	Integer nextNumber = random.nextInt(9);
        	randomString = randomString + checkValidRandomNumber(randomString, String.valueOf(nextNumber));
    	}
       System.out.println(randomString);
    	return Integer.valueOf(randomString);
    }
    
    public static String checkValidRandomNumber (String randomString, String newNumber) {
    	if(!randomString.contains(newNumber) && !newNumber.equals("0")) {
    		return newNumber;
    	}
    	return "";
    }
    
    public static void checkLengthValid (Integer inputNumber) throws Exception {
    	// String 변환
    	String inputString = String.valueOf(inputNumber);
    	// 확인
    	if(inputString.length() != FULL_COUNT_NUMBER) {
    		throw new Exception("입력한 숫자의 값이 " + FULL_COUNT_NUMBER + "자리 수가 아닙니다. 입력된 값 : [" + inputString + "]");
    	}
    }
    
    public static void checkDuplicationValid (Integer inputNumber) throws Exception {
    	// String 변환
    	String inputString = String.valueOf(inputNumber);
    	Map<String, String> numberCount = new HashMap<String, String>();
    	int size = 1;
    	while (inputString.length() >= size) {
    		String key = String.valueOf(inputString.charAt(size-1));
    		
    		checkContainStirng(numberCount, key);
    		numberCount.put(key, "EXIST");
    		size++;
    	}
    }
    
    public static void checkContainStirng (Map<String, String> numberCount, String inputStringSingle) throws Exception {
    	if("EXIST".equals(numberCount.get(inputStringSingle))) {
    		throw new Exception("입력한 숫자의 값에 중복된 숫자가 있습니다. 입력된 값 : [" + inputStringSingle + "]");
    	}
    }
    
    public static ArrayList<String> splitInputStringIntoOneDigit (Integer number) {
    	ArrayList<String> inputStringList = new ArrayList<String>();
    	String stringInput = String.valueOf(number);
    	for(int index = 0; index < stringInput.length() ; index++) {
    		inputStringList.add(String.valueOf(stringInput.charAt(index)));
    	}
    	return inputStringList;
    }
    
    public static String checkStrikeAndBall (String correctionString, String inputString, int index) {
    	
    	if(correctionString.charAt(index) == inputString.charAt(0)) {
    		return "STRIKE";
    	}
    	
    	if(correctionString.contains(inputString)) {
    		return "BALL";
    	}
    	return "NOTHING";
    }
    
    public static Map<String, Integer> countStrikeAndBall (Integer correctionNumber, Integer inputNumber) {
    	
    	Map<String, Integer> typeCount = new HashMap<String, Integer>();
    	typeCount.put("STRIKE", 0);
    	typeCount.put("BALL", 0);
    	typeCount.put("NOTHING", 0);

    	//String 변환
    	ArrayList<String> inputStringList = splitInputStringIntoOneDigit(inputNumber);
    	for(int index = 0; index < inputStringList.size(); index++) {
    		String type = checkStrikeAndBall(String.valueOf(correctionNumber), inputStringList.get(index), index);
    		typeCount.put(type, typeCount.get(type) + 1);
    	}
    	return typeCount;
    }
    
    public static Map<String, Integer> playGame (Integer correctionNumber) throws Exception {
    	
    	//입력
    	System.out.print("\n숫자를 입력해 주세요 : ");
    	Scanner input = new Scanner(System.in);
    	Integer inputNumber = input.nextInt();
    	checkLengthValid(inputNumber);
    	checkDuplicationValid(inputNumber);
    	return countStrikeAndBall(correctionNumber, inputNumber);
    
    }
    
    public static void showMessage(Map<String, Integer> result) {
    	StringBuilder message = new StringBuilder();
    	if(!result.get("STRIKE").equals(0)) {
    		message.append(result.get("STRIKE") + " 스트라이크");
    	}
    	if(!result.get("BALL").equals(0)) {
    		message.append(result.get("BALL") + " 볼");
    	}
    	if(result.get("NOTHING").equals(FULL_COUNT_NUMBER)) {
    		message.append("낫싱");
    	}
    	System.out.print(message);
    }
    
    public static void makeNewGame(int newNumber) throws Exception {
    	int strikeCount = 0;
    	
    	while(strikeCount != FULL_COUNT_NUMBER) {
    		Map<String, Integer> result = playGame(newNumber);
    		showMessage(result);
    		strikeCount = result.get("STRIKE");
    	}
    	System.out.println("\n" + FULL_COUNT_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
	
    final static Integer COUNTINUE_OPTION = 1;
    final static Integer END_OPTION = 2;
    final static Integer FULL_COUNT_NUMBER = 3;
    
    
    public static void main(String args[]) throws Exception {
    	
    	int option = 0;
    	while(option != END_OPTION) {
    		int newNumber = makeRandomNumber();
    		makeNewGame(newNumber);
    		System.out.print("\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    		Scanner input = new Scanner(System.in);
    		option = input.nextInt();        	
    	}

    	System.out.println("\n게임 오버");
    	
    }
}
