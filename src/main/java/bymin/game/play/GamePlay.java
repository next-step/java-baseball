package bymin.game.play;

import bymin.game.constans.GameResult;
import bymin.game.constans.Rule;

import java.util.*;

public class GamePlay {
	Scanner sc;

	public String run() {
		sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 : ");
		return sc.next();
	}

	public String play(Map<String, Integer> mapResult, String setString, ArrayList<Integer> numList) {
		char[] userBall = setString.toCharArray();
		if (userBall.length > 3) {
			System.out.println("3 자리 숫자를 입력해주세요");
			return Rule.RELOAD.getPlayType();
		}
		gameCheckRuleFirstNumber(numList, setString.toCharArray(), mapResult);
		resultMessage(mapResult);
		return result(mapResult);
	}

	public void gameCheckRuleFirstNumber(List<Integer> list, char[] chars, Map<String, Integer> mapResult) {
		for (int i = 0; i < list.size(); i++) {
			gameCheckUserNumber(i, list.get(i), chars, mapResult);
		}
	}

	public void gameCheckUserNumber(int numberCheck, int ball, char[] chars, Map<String, Integer> mapResult) {
		for (int i = 0; i < chars.length; i++) {
			gemeCheckStrike(numberCheck, i, Integer.parseInt(String.valueOf(chars[i])) == ball, mapResult);
		}
	}

	public void gemeCheckStrike(int numberCheck, int charCheck, boolean check, Map<String, Integer> mapResult) {
		if (numberCheck == charCheck && check) {
			mapResult.put(GameResult.STRIKE, mapResult.get(GameResult.STRIKE) + 1);
			return;
		}

		if (check) {
			mapResult.put(GameResult.BALL, mapResult.get(GameResult.BALL) + 1);
		}
	}

	public void resultMessage(Map<String, Integer> mapResult) {
		Set<String> resultSet = mapResult.keySet();
		for (String result : resultSet) {
			System.out.print(subMessage(mapResult.get(result), result));
		}
	}

	public String subMessage(int a, String b) {
		if (a > 0) {
			return a + " " + b;
		}
		return " ";
	}

	public String result(Map<String, Integer> mapResult) {
		if (mapResult.get(GameResult.STRIKE) == 3) {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
			return sc.next();
		}
		return null;
	}

}
