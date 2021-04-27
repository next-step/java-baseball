package player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerFactoryTest {

	private PlayerFactory playerFactory;

	@BeforeEach
	void setIp() {
		playerFactory = PlayerFactory.getInstance();
	}

	@Test
	@DisplayName("computer 객체가 발생하는지 테스트")
	public void computer() {
		assertThat(playerFactory.computer()).isExactlyInstanceOf(Computer.class).isNotNull();
	}

	@Test
	@DisplayName("user 객체가 발생하는지 테스트")
	public void user() {
		assertThat(playerFactory.user()).isExactlyInstanceOf(User.class).isNotNull();
	}
}
