package home.work.baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CommandLineInterface {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static boolean printWin() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		while(true) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			try {
				return readExitInput();
			} catch (Exception e1) {
				System.out.println("정확한 숫자를 입력해주세요.");
			}
		}
	}
	
	private static boolean readExitInput() {
		int inputNum = scanner.nextInt();
		if (inputNum == 1) return true;
		if (inputNum == 2) return false;
		throw new RuntimeException();
	}
	
	public static List<Integer> receiveNums(Player player, int size) {
		if (player == null) throw new IllegalArgumentException("질문할 플레이어가 없습니다.");
		if (player.isCpu()) return cpuEnterNum(size);
		while(true) {
			System.out.print(String.format("[%s] 숫자를 입력해주세요 : ", player.getName()));
			try {
				return playerEnterNum(size);
			} catch (Exception e1) {
				System.out.println("잘못 입력했습니다.(" + e1.getMessage() + ")");
			}
		}
	}
	
	private static List<Integer> cpuEnterNum(int size) {
		List<Integer> randomNums = RandomUtils.generateNums(size);
		randomNums.forEach(System.out::print);
		System.out.println();
		return randomNums;
	}

	private static List<Integer> playerEnterNum(int size) {
		List<Integer> parseInput = parseInput(scanner.nextInt(), size);
		validateInput(parseInput, size);
		return parseInput;
	}
	
	public static void printAnswer(Answer answer) {
		if (answer == null) throw new IllegalArgumentException("대답이 없습니다.");
		System.out.println(answer.print());
	}
	
	private static void validateInput(List<Integer> parseInput, int size) {
		Set<Integer> numSet = new HashSet<>();
		numSet.addAll(parseInput);
		if (numSet.size() != size) {
			throw new RuntimeException();
		}
	}
	
	private static List<Integer> parseInput(int inputNum, int size) {
		List<Integer> returnList = Arrays.asList(new Integer[size]);
		int temp = inputNum;
		for (int i = 0; i < size; i++) {
			returnList.set(size -1 -i, temp % 10);
			temp /= 10;
		}
		return returnList;
	}
	
}
