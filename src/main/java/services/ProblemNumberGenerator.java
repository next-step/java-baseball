package services;

import java.util.*;

public class ProblemNumberGenerator {
	public List<Integer> generate() {
		Random random = new Random();
		Set<Integer> problemNumbers = new LinkedHashSet<>();

		while (problemNumbers.size() < 3) {
			problemNumbers.add(random.nextInt(9) + 1);
		}

		return new ArrayList<>(problemNumbers);
	}
}
