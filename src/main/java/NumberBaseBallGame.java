import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import exception.InvalidValueException;
import service.IInitializer;
import service.impl.Initializer;

public class NumberBaseBallGame {

	private final static IInitializer iInitializer = new Initializer();

	public static void main(String[] args) {

		final Map<Integer, Integer> computerNumber = iInitializer.initComputerNumber();

		boolean gameOver = false;
		while (!gameOver) {
			gameOver = runningGameStage(computerNumber);
		}
	}

	/**
	 * 게임 스테이지를 진행
	 */
	private static boolean runningGameStage(final Map<Integer, Integer> computerNumber) {
		final Scanner scanner = new Scanner(System.in);

		System.out.print("숫자를 입력해주세요 : ");
		try {
			final int[] ints = iInitializer.initPlayerNumber(scanner.nextInt());
		} catch (InvalidValueException | InputMismatchException e) {
			System.out.println("유효하지 않은 숫자입니다!");
			return false;
		} catch (Exception e) {
			System.out.println("게임이 비정상적으로 종료되었습니다.");
			return true;
		}

		return false;
	}
}
