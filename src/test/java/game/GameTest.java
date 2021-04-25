package game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import player.Computer;
import player.PlayerFactory;
import player.User;

public class GameTest {
	
	private Game game;

	@BeforeEach
	void setIp() {
		game = new Game(PlayerFactory.getInstance().user());
	}
	
	@Test
	@DisplayName("computer 객체가 있는지 테스트")
	void getComputer() {
		assertThat(game.getComputer()).isExactlyInstanceOf(Computer.class).isNotNull();
	}
	
	@Test
	@DisplayName("user 객체가 있는지 테스트")
	void getUser() {
		assertThat(game.getUser()).isExactlyInstanceOf(User.class).isNotNull();
	}
	
}
