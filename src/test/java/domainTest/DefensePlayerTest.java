package domainTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import domain.participants.DefensePlayer;
import domain.Numbers;

public class DefensePlayerTest {

	@DisplayName("answer리스트 내부에 숫자 3개가 들어가 있는지 점검")
	@Test
	void getAnswer_ContainsThreeNumber(){
		//Given
		DefensePlayer defensePlayer = new DefensePlayer();

		//when
		Numbers answer = defensePlayer.decideAnswerNumber();
		
		//then
		assertThat(answer.length()).isEqualTo(3);
	}


}
