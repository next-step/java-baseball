package baseball.ui;

import baseball.GameStatus;

import java.util.Scanner;

import static baseball.GameStatus.RESTART;
import static baseball.GameStatus.SHUTDOWN;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 2021/04/27
 * Time : 11:46 AM
 */

public class BaseballGameUI {
	public GameStatus selectRestartOrExit() {
		print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt() == 1 ? RESTART : SHUTDOWN;
	}

	public String inputUserBalls() {
		Scanner scanner = new Scanner(System.in);
		print("숫자를 입력해주세요: ");
		return scanner.next();
	}

	public void print(String message) {
		System.out.println(message);
	}
}
