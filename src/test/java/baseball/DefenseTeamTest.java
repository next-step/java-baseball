package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefenseTeamTest {
	private DefenseTeam defenseTeam;

	@BeforeEach
	void setUp() {
		this.defenseTeam = new DefenseTeam();
	}

	@AfterEach
	void tearDown() {
		this.defenseTeam = null;
	}


	@Test
	void prepareDefenseNumbers() { /* do not test */ }

	@Test
	void getDefenseNumbers() { /* do not test */ }
}
