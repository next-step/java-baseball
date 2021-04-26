package jbh.numberbaseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class PcTeamTest {

	PcTeam pcTeam = new PcTeam();

	@RepeatedTest(value = 100)
	@DisplayName("initNewBall 호출 시 새로운 난수 생성. 반복 생성된 난수의 값 비교 진행")
	public void requestRandomTextTest() {
		pcTeam.initNewBall();
		String randomText = pcTeam.getBall();
		assertThat(randomText).isNotEmpty();
	}
}
