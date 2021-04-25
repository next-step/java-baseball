package player;

import number.RandomGenerationStrategy;
import number.UserInputGenerationStrategy;

public class PlayerFactory {
	
	public Computer computer() {
		return new Computer(RandomGenerationStrategy.getInstance());
	}
	
	public User user() {
		return new User(UserInputGenerationStrategy.getInstance());
	}
}
