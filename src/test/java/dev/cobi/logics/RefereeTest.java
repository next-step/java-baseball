package dev.cobi.logics;

import dev.cobi.domains.PlayNumber;
import dev.cobi.domains.ResultScore;
import dev.cobi.domains.ResultType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author cobiyu
 */
class RefereeTest {
	private Referee referee;

	@BeforeEach
	public void setup(){
		referee = new Referee();
	}

	@Test
	@DisplayName("strike, ball 전체 테스트")
	public void resultScore(){
		// answerNumber, playNumber, strike, ball
		Object[][] gameDataSet = {
			{"381", "726", 0, 0},
			{"381", "138", 0, 3},
			{"381", "123", 0, 2},
			{"381", "315", 1, 1},
			{"381", "458", 0, 1},
			{"381", "683", 1, 1},
			{"381", "561", 1, 0},
			{"381", "587", 1, 0},
			{"381", "281", 2, 0},
			{"381", "381", 3, 0},
		};

		for (Object[] dataSet : gameDataSet) {
			ResultScore resultScore = referee.getResultScore(
				new PlayNumber(dataSet[0].toString()),
				new PlayNumber(String.valueOf(dataSet[1]))
			);

			assertEquals(resultScore.getStrike(), dataSet[2]);
			assertEquals(resultScore.getBall(), dataSet[3]);
		}
	}

	@Test
	@DisplayName("ball 테스트")
	public void ball(){
		// answerNumber, searchCharacter, index
		Object[][] ballDataSet = {
			{"123", '1', 1},
			{"381", '1', 1},
			{"496", '4', 2},
			{"193", '3', 0},
			{"327", '7', 1}
		};

		for (Object[] dataSet : ballDataSet) {
			ResultType resultType = referee.getResultTypeByString(
				new PlayNumber(dataSet[0].toString()),
				(char) dataSet[1],
				(int) dataSet[2]
			);

			assertEquals(resultType, ResultType.BALL);
		}
	}

	@Test
	@DisplayName("strike 테스트")
	public void strike(){
		// answerNumber, searchCharacter, index
		Object[][] ballDataSet = {
			{"123", '1', 0},
			{"381", '1', 2},
			{"496", '4', 0},
			{"193", '3', 2},
			{"327", '7', 2}
		};

		for (Object[] dataSet : ballDataSet) {
			ResultType resultType = referee.getResultTypeByString(
				new PlayNumber(dataSet[0].toString()),
				(char) dataSet[1],
				(int) dataSet[2]
			);

			assertEquals(resultType, ResultType.STRIKE);
		}
	}

	@Test
	@DisplayName("nothing 테스트")
	public void nothing(){
		Object[][] ballDataSet = {
			{"123", '9', 0},
			{"381", '9', 2},
			{"496", '5', 0},
			{"193", '2', 2},
			{"327", '4', 2}
		};

		for (Object[] dataSet : ballDataSet) {
			ResultType resultType = referee.getResultTypeByString(
				new PlayNumber(dataSet[0].toString()),
				(char) dataSet[1],
				(int) dataSet[2]
			);

			assertEquals(resultType, ResultType.NOTHING);
		}
	}
}
