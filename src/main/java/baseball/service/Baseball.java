package baseball.service;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

import baseball.domain.Balls;
import baseball.util.Message;

public class Baseball {
	
	public Balls balls;
	
	public Balls inputBalls;
	//숫자설정시 한자리에 허용하는 최대 값
	private static final int BALL_MAX_VALUE = 9;
	//숫자설정시 한자리에 허용하는 최소 값
	private static final int BALL_MIN_VALUE = 1;
	
	private final Scanner scanner = new Scanner(System.in);
	
	public Baseball(){		
	}

	public void startGame() {
		//숫자 생성
		this.balls = generateAutoNumber();
		//to_do: 입력값 받기
		this.inputBalls = registerBallNumbers(inputString(Message.INPUT_NUMBER));		
		//to_do: 값 비교
		//to_do: 결과 도출
		//to_do: 재시작,종료 제어
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
		//System.err.println(ballBuilder.toString());
		return ballBuilder.toString();
	}
	
	public String inputString(String message) {
        System.out.println(message);
        return scanner.next();
    }

	public Balls registerBallNumbers(String inputString) {
		return new Balls(inputString);
	}
}
