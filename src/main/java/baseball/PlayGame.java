package baseball;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class PlayGame {
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);

		BaseballGame baseballGame = new BaseballGame();

		System.out.print("숫자를 입력해주세요 :");
		String input = sc.nextLine();

		if(!baseballGame.checkRule(input)){
			return;
		}

	}
}
