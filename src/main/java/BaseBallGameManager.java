import java.util.List;
import java.util.Set;

public class BaseBallGameManager {

	public final int NUMBER_LIMIT = 3;
	private BaseBallNumberGenerator baseBallNumberGenerator;
	private UserInputReader userInputReader;

	public BaseBallGameManager() {
		// 사용자 입력  UI
		userInputReader = new UserInputReader();
		// 야구게임 숫자 생성기
		baseBallNumberGenerator = new BaseBallNumberGenerator(NUMBER_LIMIT);
	}

	/**
	 * 야구게임 통합 실행 메소드
	 */
	public void run() throws Exception {
		int strikeCount = 0;
		String computerInput = baseBallNumberGenerator.makeComputerNumbers(9, null);
		List<String> comNumberList = baseBallNumberGenerator.makeNumberList(computerInput);
		if (startGame(comNumberList, 0)) {
			run();
		}
		userInputReader.closeBuffer();
	}

	public boolean startGame(List<String> comNumberList, int countStrike) throws Exception {
		if (countStrike == NUMBER_LIMIT) {
			return false;
		}

		String userInput = userInputReader.makeUserNumbers();
		List<String> userNumberList = baseBallNumberGenerator.makeNumberList(userInput);
		if (!baseBallNumberGenerator.checkListSize(userNumberList)) {
			System.out.println("잘못된 입력 값입니다. 다시 입력 해 주시길 바랍니다.");
			startGame(comNumberList, 0);
			return false;
		}

		int resultCountStrike = countStrike(userNumberList, comNumberList, 0, 0);
		return startGame(comNumberList, resultCountStrike);
	}

	public int countStrike(List<String> targetList, List<String> compareList, int index, int count) {
		int result = count;
		if (index == NUMBER_LIMIT) {
			return result;
		}
		if (targetList.get(index).equals(compareList.get(index))) {
			result++;
		}
		return countStrike(targetList, compareList, ++index, result);
	}

	public int countBalls(List<String> targetList, List<String> compareList, Set<String> compareSet, int index,
		int count) {

		int result = count;
		if (index == NUMBER_LIMIT) {
			return result;
		}
		if (compareSet.contains(targetList.get(index)) && !targetList.get(index).equals(compareList.get(index))) {
			result++;
		}
		return countBalls(targetList, compareList, compareSet, ++index, result);
	}
}
