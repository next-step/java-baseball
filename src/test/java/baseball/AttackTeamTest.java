package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AttackTeamTest {
	private AttackTeam attackTeam = new AttackTeam();

	@BeforeEach
	void setUp() {
		this.attackTeam = new AttackTeam();
	}

	@AfterEach
	void tearDown() {
		this.attackTeam = null;
	}

	@Test
	void initAttackNumbers() {
		attackTeam.initAttackNumbers();
		String attackNumbers1 = attackTeam.getAttackNumbers();

		attackTeam.initAttackNumbers();
		String attackNumbers2 = attackTeam.getAttackNumbers();

		assertThat(attackNumbers1).isNotEqualTo(attackNumbers2);
	}

	@Test
	void getAttackNumbers() {
		attackTeam.initAttackNumbers();
		String attackNumbers = attackTeam.getAttackNumbers();

		List<Integer> attackNumberList = new ArrayList<>();
		for (String numStr : attackNumbers.split("")) {
			attackNumberList.add(Integer.parseInt(numStr));
		}

		assertThat(attackNumberList)
			.hasSize(3)
			.filteredOn(num -> !attackNumberList.contains(num))
			.filteredOn(num -> num < 10)
			.filteredOn(num -> num > 0);
	}
}
