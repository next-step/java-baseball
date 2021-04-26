import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BaseBallGame {
	List<Integer> computerPlayer;
	int userPlayer = 0;

	/*
	 * 숫자야구게임 시작
	 * */
	public void start() {
		System.out.println("숫자야구게임 시작");
		computerPlayer = generateComputerPlayer();
	}

	public List<Integer> generateComputerPlayer() {
		Set<Integer> selectNumbers = new HashSet<>();
		List<Integer> computerNumbers;
		Random random = new Random();

		while (selectNumbers.size() < 3) {
			selectNumbers.add(random.nextInt(9));
		}

		computerNumbers = new ArrayList<>(selectNumbers);

		return computerNumbers;
	}

}
