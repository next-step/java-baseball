import java.util.Arrays;
import java.util.Scanner;

public class NumberBaseballGame {
	
	public final static int RANDOM_DIGIT = 3;
	
	public static void main(String[] args) {
		
		//Scanner scanner = new Scanner(System.in);

		//System.out.print("숫자를 입력해주세요 : ");

		//String str = scanner.next();
		
		int tempNum = 123; //임시로 숫자 입력받지 않고 선언해서 테스트 TODO: 개발 후 삭제

		// 랜덤 세자리 정수 생성
		generateRandomNumDigitException(RANDOM_DIGIT);
		int randomNum = generateRandomNumDigit(RANDOM_DIGIT);
		
		System.out.println("랜덤 생성된 정수 : " + randomNum);

		// 숫자 입력 받아서 스트라이크/ 볼 / 게임종료 판정
		
		
		//볼카운트
		int ballCount = countBall(randomNum, tempNum);

		// 게임을 새로 시작할지 ? 게임을 종료할지 여부 받기
		
		System.out.println("볼카운트 : " + ballCount);

		//scanner.close();

	}

	/**
	 * 
	 * 1~9까지의 서로 다른 수로 이루어진 digit자리의 수를 생성
	 * 
	 * @param digit 랜덤 생성할 수의 자릿수
	 * @return randomNum 생성된 랜덤 정수
	 * @author somi
	 * 
	 */
	private static int generateRandomNumDigit(int digit) {
		int randomTmp;
		String randomNum = (int)((Math.random() * 10000) % 9) + 1 + "";

		while (randomNum.length() != digit) { // 입력받은 자릿수가 될 때 까지
			randomTmp = (int)((Math.random() * 10000) % 9) + 1; // 1자리 정수 생성
			randomNum = (randomNum.contains(randomTmp + "")) ? randomNum : randomNum + randomTmp;
		}

		return Integer.parseInt(randomNum);
	}
	
	
	/**
	 * 
	 * generateRandomNumDigit 실행시 범위를 벗어날 경우 예외처리 (범위 : 1~9)
	 * 
	 * @param digit 랜덤 생성할 수의 자릿수
	 * @author somi
	 * 
	 */
	private static void generateRandomNumDigitException(int digit) {
		
		String message = "랜덤으로 생성되는 자릿수는 1~9까지 입니다.";

		if (digit < 1 || digit > 9) {
			System.out.println(message);
			System.exit(0);
		}

	}
	
	
	
	/**
	 * 
	 * ball 카운트
	 * 
	 * @param randomNum 랜덤정수, inputNum 입력받은 정수
	 * @return ball ball 카운트
	 * @author somi
	 * 
	 */
	private static int countBall(int randomNum, int inputNum) {
		int ball = 0;
		String[] randomNumArr = (randomNum + "").split("");
		
		for (String randomNumArrInex : randomNumArr) {
			ball = ((inputNum + "").contains(randomNumArrInex)) ? ball + 1 : ball;
		}
		
		return ball;
	}
	
	
	
}
