package baseball.service;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

import baseball.domain.Balls;
import baseball.util.Exception;
import baseball.util.Message;
import baseball.util.Validation;

public class Baseball {
	
	public Balls balls;
	
	public Balls inputBalls;
	//숫자설정시 한자리에 허용하는 최대 값
	private static final int BALL_MAX_VALUE = 9;
	//숫자설정시 한자리에 허용하는 최소 값
	private static final int BALL_MIN_VALUE = 1;
	//입력자리수
	private static final int BALL_STATUS_LENGTH = 3;
	
	public int strike = 0;
	
	public int ball = 0;
	
	private final Scanner scanner = new Scanner(System.in);
	
	public Baseball(){		
	}

	public void startGame() {
		//숫자 생성
		this.balls = generateAutoNumber();
		while(true) {
			//to_do: 입력값 받기
			this.inputBalls = registerBallNumbers(inputString(Message.INPUT_NUMBER));
			//to_do: 값 비교
			valueCompare();
			//to_do: 결과 도출
			getGameScore();
		if(clearBallCount()) break;
		}
		//to_do: 재시작,종료 제어
		checkRestart(inputString(Message.INPUT_MSG_COUNTINUE));
	}
	
	private void checkRestart(String string) {
		if("1".equals(string))
			startGame();
			
		if("2".equals(string))
			endGame();
	}

	private void endGame() {
		System.out.println(Message.INPUT_MSG_END_GAME);
	}
	
	private void getGameScore() {

		if(strike > 0 && ball >0) 
			System.out.println(strike+Message.INPUT_MSG_STRIKE+" "+ball+Message.INPUT_MSG_BALL);
		if(strike > 0 && ball == 0)
			System.out.println(strike+Message.INPUT_MSG_STRIKE);
		if(strike == 0 && ball > 0)
			System.out.println(ball+Message.INPUT_MSG_BALL);
		if(strike == 0 && ball == 0)
			System.out.println(Message.INPUT_MSG_NOTHING);
		if(strike == 3)
			System.out.println(Message.INPUT_MSG_SUCCESS);
		
	}
	
	private boolean clearBallCount() {
		boolean countinue = false;
		
		if(strike == 3) 
			countinue = true;
		
		strike = 0;		
		ball = 0;
		
		return countinue;
	}
	
	public void valueCompare() {
		
		for(int idx=0; idx<balls.getBalls().size(); idx++) {
			isStricke(balls.getBalls().get(idx).getBall(), idx);
		}
	}

	private void isStricke(String ballVal, int compareIdx) {
		for(int idx=0; idx<inputBalls.getBalls().size(); idx++) {

			if(inputBalls.getBalls().get(idx).getBall().equals(ballVal) && idx == compareIdx) {
				strike++;
			}
			if(inputBalls.getBalls().get(idx).getBall().equals(ballVal) && idx != compareIdx) {
				ball++;
			}
		}
	}

	public Balls generateAutoNumber() {
		//중복을 제거하면서 3자리 숫자를 담기위해 LinkedHashSet을 사용.
		LinkedHashSet<String> ballTemp = new LinkedHashSet<>();
		Random random = new Random();
		//랜덤한 1~9까지의 값을 설정.
		while(ballTemp.size() < 3) {
			String num = String.valueOf(random.nextInt(BALL_MAX_VALUE) + BALL_MIN_VALUE);
			ballTemp.add(num);
		}
		
		return new Balls(makeBalls(ballTemp));
	}
	
	public String makeBalls(LinkedHashSet<String> ballTemp) {
		StringBuilder ballBuilder = new StringBuilder();
		Iterator<String> it = ballTemp.iterator();
		while(it.hasNext()){
			ballBuilder.append((String) it.next());
		}
		
		return ballBuilder.toString();
	}
	
	public String inputString(String message) {
        System.out.println(message);
        return scanner.next();
    }

	public Balls registerBallNumbers(String inputString) {
		if(Validation.nullCheckString(inputString)) {
            Exception.nullPointerException(Message.INPUT_MSG_NULL);
        }

		if(inputString.length() != BALL_STATUS_LENGTH) {
			Exception.illegalArgumentException(Message.INPUT_MSG_LENTH_LIMIT);
		}
		return new Balls(inputString);
	}
}
