package domainTest;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import domain.Game;

public class GameTest {

	@Test
	void createParticipantsWhenGameConstructed(){
		//Given+When
		Game game = new Game();

		//Then
		assertThat(game.getDefensePlayer()).isNotNull();
		assertThat(game.getOffensePlayer()).isNotNull();
		assertThat(game.getUmpire()).isNotNull();
	}

	@Test
	void setStatusWhenGameConstructed(){
		//Given+When
		Game game = new Game();

		//Then
		assertThat(game.getStatus()).isEqualTo(Game.Status.ONGOING);

	}


}
