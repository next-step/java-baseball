package com.github.baekss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import com.github.baekss.domain.Computer;
import com.github.baekss.domain.JoinStatus;
import com.github.baekss.domain.Player;

public class BaseBallGameMain {

	/* 플레이어의 입력값 검증 기능 */
	private static boolean checkInput(String input, String invalidValue, int length) {
		boolean flag = true;
		
		try {
			InputChecker.checkNumberFormat(input);
			InputChecker.checkInputLength(input, length);
			InputChecker.checkInvalidValue(input, invalidValue);
			InputChecker.isUniqueEachValue(input, length);
		} catch (Exception e) {
			flag = false;
			System.out.println("입력 : " + input + " [" + e.getMessage() + "]");
		}
		return flag;
	}
	
	private static void printMessage(JoinStatus status) {
		String message = "숫자를 입력해주세요 : ";
		if (status == JoinStatus.STOP) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			message = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
		}
		System.out.print(message);
	}
	
	private static boolean playBaseBall(String threeDigitNumberString, Player player, Computer computer) {
		if (checkInput(threeDigitNumberString, "0", 3)) {
			Set<Integer> ThreeDigitNumber = player.getThreeDigitNumber(threeDigitNumberString);
			return computer.compareInputNumberToComputerNumbers(ThreeDigitNumber);
		}
		return false;
	}
	
	private static Computer rejoinGame(boolean rejoin, Player player, BufferedReader reader, Computer computer) throws IOException {
		if (rejoin) {
			player.setStatus(JoinStatus.STOP);
			printMessage(player.getStatus());
			String response = reader.readLine();
			if ("1".equals(response)) {
				player.setStatus(JoinStatus.JOIN);
				computer = Computer.createComputer(3, 1, 9);
			}
		}
		return computer;
	}
	
	public static void main(String[] args) throws Exception {
		Computer computer = Computer.createComputer(3, 1, 9);
		Player player = Player.createPlayer(JoinStatus.JOIN);
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			while (player.getStatus() == JoinStatus.JOIN) {
				printMessage(player.getStatus());
				String threeDigitNumberString = reader.readLine();
				computer = rejoinGame(playBaseBall(threeDigitNumberString, player, computer), player, reader, computer);
			}
		} catch (IOException ioe) {
			throw ioe;
		}
	}
}
