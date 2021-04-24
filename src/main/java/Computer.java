import java.util.Set;
import java.util.TreeSet;

public class Computer {

	private Set<Integer> ballSet = new TreeSet<>();

	private int numberRandom(int min, int max) {
		return (int)(Math.random() * max + min);
	}

	public int getMaxBallSize() {
		return 3;
	}

	public Set<Integer> getBallSet() {
		return ballSet;
	}

	public void setBallSet() {
		Set<Integer> ballSet = new TreeSet<>();
		int randomMin = 1;
		int randomMax = 10;

		while (ballSet.size() != this.getMaxBallSize()) {
			ballSet.add(this.numberRandom(randomMin, randomMax));
		}
		this.ballSet = ballSet;
	}
}
