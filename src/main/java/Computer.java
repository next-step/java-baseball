import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Computer {
	private List<Integer> computerNumbers;

	public List<Integer> getComputerNumbers() {
		return computerNumbers;
	}

	public void generateNumbers() {
		Set<Integer> selectNumbers = new HashSet<>();
		Random random = new Random();

		while (selectNumbers.size() < 3) {
			selectNumbers.add(random.nextInt(9));
		}

		computerNumbers = new ArrayList<>(selectNumbers);
	}
}
