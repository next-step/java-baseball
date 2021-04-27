package baseball;

public class Umpire {
	private boolean isStrike(char attackNumber, char defenseNumber) {
		return attackNumber == defenseNumber;
	}

	private boolean isBall(String attackNumbers, char attackNumber, char defenseNumber) {
		if (isStrike(attackNumber, defenseNumber)) {
			return false;
		}
		return attackNumbers.contains(String.valueOf(defenseNumber));
	}

	public Score judge(String attackNumbers, String defenceNumbers) {
		int strikeCount = 0;
		int ballCount = 0;
		for (int i = 0; i < attackNumbers.length(); i++) {
			char attackNumber = attackNumbers.charAt(i);
			char defenceNumber = defenceNumbers.charAt(i);
			strikeCount += isStrike(attackNumber, defenceNumber) ? 1 : 0;
			ballCount += isBall(attackNumbers, attackNumber, defenceNumber) ? 1 : 0;
		}

		return new Score(strikeCount, ballCount);
	}
}
