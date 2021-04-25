package player;

import number.RandomGenerationStrategy;
import number.UserInputGenerationStrategy;

public class PlayerFactory {

	private static PlayerFactory playerFactory = new PlayerFactory();

	private PlayerFactory() {
	}

	public static PlayerFactory getInstance() {
		return playerFactory;
	}

	public Computer computer() {
		return new Computer(RandomGenerationStrategy.getInstance());
	}

	public User user() {
		return new User(UserInputGenerationStrategy.getInstance());
	}
}
