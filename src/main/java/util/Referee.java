package util;

public class Referee {
	// 스트라이크 판정값을 리턴하는 메서드
	public static int isStrike(int index, String answer, String target) {
		if ( answer.charAt(index) == target.charAt(index)) { // 같은 인덱스에 있는 두 숫자가 동일할 경우
			return 1;
		}
		return 0;
	}

	// 볼 판정값을 리턴하는 메서드
	public static int isBall(int index, String answer, String target) {
		if ( answer.charAt(index) != target.charAt(index)
			&& target.contains(String.valueOf(answer.charAt(index)))) { // 같은 인덱스에 있는 두 숫자는 다르지만 다른 자리에 해당 숫자가 있을 경우
			return 1;
		}
		return 0;
	}

	// 결과를 출력하는 메서드
	public static String refereeDecision(int[] checkArray) {
		if (checkArray[0] == 0 && checkArray[1] == 0) {
			return "낫싱";
		}

		StringBuilder returnStr = new StringBuilder();

		if (checkArray[0] != 0 ) {
			returnStr.append(checkArray[0]).append(" 스트라이크 ");
		}

		if (checkArray[1] != 0 ) {
			returnStr.append(checkArray[1]).append(" 볼");
		}

		return returnStr.toString();
	}
}
