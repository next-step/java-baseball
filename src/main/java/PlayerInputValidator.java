import java.util.HashSet;
import java.util.Set;

/**
 * 플레이어의 입력오류를 방지하기 위한 클래스
 */
public class PlayerInputValidator {
	public static boolean validatePlayerNumbersLength(int[] playerInputNumbers) {
		if (playerInputNumbers.length != 3) {
			System.out.println("숫자를 3자리를 입력해 주세요.");
			return false;
		}
		return true;
	}

	public static boolean validatePlayerNumbersDuplicate(int[] playerInputNumbers) {
		Set<Integer> duplicateRemovedGameNumbers = new HashSet<>();
		for (int playerInputNumber : playerInputNumbers) {
			duplicateRemovedGameNumbers.add(playerInputNumber);
		}

		if (duplicateRemovedGameNumbers.size() < 3) {
			System.out.println("중복된 숫자가 있습니다. 중복되지 않는 숫자를 입력하세요.");
			return false;
		}

		return true;
	}
}
