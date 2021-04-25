package domainTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import domain.game.GameStatus;
import domain.participants.DefensePlayer;
import domain.game.Game;

public class GameTest {

	@DisplayName("Game 객체 생성 시, 다른 객체들도 생성됨")
	@Test
	void createParticipantsWhenGameConstructed(){
		//Given+When
		Game game = new Game();

		//Then
		assertThat(game.getDefensePlayer()).isNotNull();
		assertThat(game.getOffensePlayer()).isNotNull();
		assertThat(game.getUmpire()).isNotNull();
	}

	@DisplayName("Game 객체 생성 시, status가 ONGOING으로 설정됨")
	@Test
	void setStatusWhenGameConstructed(){
		//Given+When
		Game game = new Game();

		//Then
		assertThat(game.getStatus()).isEqualTo(GameStatus.ONGOING);
	}
}
