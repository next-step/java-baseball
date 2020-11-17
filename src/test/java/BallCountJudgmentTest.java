import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import NumberBaseballGame.Answer;
import NumberBaseballGame.BallCountJudgment;

class BallCountJudgmentTest {

	@Test
	void threeStrike() {
		Answer answer = new Answer(1, 2, 3);
		int[] inputData = {1, 2, 3};

		BallCountJudgment judgment = new BallCountJudgment(inputData, answer);
		judgment.judgeBallCount();

		assertEquals(3, judgment.getBallCountJudgment().getStrike());
		assertEquals(0, judgment.getBallCountJudgment().getBall());
	}

	@Test
	void twoStrike() {
		Answer answer = new Answer(1, 2, 3);

		// case 1
		int[] inputData1 = {1, 2, 9};

		BallCountJudgment judgment1 = new BallCountJudgment(inputData1, answer);
		judgment1.judgeBallCount();

		assertEquals(2, judgment1.getBallCountJudgment().getStrike());
		assertEquals(0, judgment1.getBallCountJudgment().getBall());

		// case 2
		int[] inputData2 = {1, 9, 3};
		BallCountJudgment judgment2 = new BallCountJudgment(inputData2, answer);
		judgment2.judgeBallCount();

		assertEquals(2, judgment2.getBallCountJudgment().getStrike());
		assertEquals(0, judgment2.getBallCountJudgment().getBall());

		// case 3
		int[] inputData3 = {9, 2, 3};
		BallCountJudgment judgment3 = new BallCountJudgment(inputData3, answer);
		judgment3.judgeBallCount();

		assertEquals(2, judgment3.getBallCountJudgment().getStrike());
		assertEquals(0, judgment3.getBallCountJudgment().getBall());
	}

	@Test
	void oneStrike() {
		Answer answer = new Answer(1, 2, 3);

		// case 1
		int[] inputData1 = {1, 8, 9};
		BallCountJudgment judgment1 = new BallCountJudgment(inputData1, answer);
		judgment1.judgeBallCount();

		assertEquals(1, judgment1.getBallCountJudgment().getStrike());
		assertEquals(0, judgment1.getBallCountJudgment().getBall());

		// case 2
		int[] inputData2 = {8, 2, 9};
		BallCountJudgment judgment2 = new BallCountJudgment(inputData2, answer);
		judgment2.judgeBallCount();

		assertEquals(1, judgment2.getBallCountJudgment().getStrike());
		assertEquals(0, judgment2.getBallCountJudgment().getBall());

		// case 3
		int[] inputData3 = {9, 8, 3};
		BallCountJudgment judgment3 = new BallCountJudgment(inputData3, answer);
		judgment3.judgeBallCount();

		assertEquals(1, judgment3.getBallCountJudgment().getStrike());
		assertEquals(0, judgment3.getBallCountJudgment().getBall());
	}

	@Test
	void oneStrikeTwoBall() {
		Answer answer = new Answer(1, 2, 3);

		// case 1
		int[] inputData1 = {1, 3, 2};
		BallCountJudgment judgment1 = new BallCountJudgment(inputData1, answer);
		judgment1.judgeBallCount();

		assertEquals(1, judgment1.getBallCountJudgment().getStrike());
		assertEquals(2, judgment1.getBallCountJudgment().getBall());

		// case 2
		int[] inputData2 = {3, 2, 1};
		BallCountJudgment judgment2 = new BallCountJudgment(inputData2, answer);
		judgment2.judgeBallCount();

		assertEquals(1, judgment2.getBallCountJudgment().getStrike());
		assertEquals(2, judgment2.getBallCountJudgment().getBall());

		// case 3
		int[] inputData3 = {2, 1, 3};
		BallCountJudgment judgment3 = new BallCountJudgment(inputData3, answer);
		judgment3.judgeBallCount();

		assertEquals(1, judgment3.getBallCountJudgment().getStrike());
		assertEquals(2, judgment3.getBallCountJudgment().getBall());
	}

	@Test
	void oneStrikeOneBall() {
		Answer answer = new Answer(1, 2, 3);

		// case 1
		int[] inputData1 = {1, 3, 9};
		BallCountJudgment judgment1 = new BallCountJudgment(inputData1, answer);
		judgment1.judgeBallCount();

		assertEquals(1, judgment1.getBallCountJudgment().getStrike());
		assertEquals(1, judgment1.getBallCountJudgment().getBall());

		// case 2
		int[] inputData2 = {1, 9, 2};
		BallCountJudgment judgment2 = new BallCountJudgment(inputData2, answer);
		judgment2.judgeBallCount();

		assertEquals(1, judgment2.getBallCountJudgment().getStrike());
		assertEquals(1, judgment2.getBallCountJudgment().getBall());

		// case 3
		int[] inputData3 = {3, 2, 9};
		BallCountJudgment judgment3 = new BallCountJudgment(inputData3, answer);
		judgment3.judgeBallCount();

		assertEquals(1, judgment3.getBallCountJudgment().getStrike());
		assertEquals(1, judgment3.getBallCountJudgment().getBall());

		// case 4
		int[] inputData4 = {9, 2, 1};
		BallCountJudgment judgment4 = new BallCountJudgment(inputData4, answer);
		judgment4.judgeBallCount();

		assertEquals(1, judgment4.getBallCountJudgment().getStrike());
		assertEquals(1, judgment4.getBallCountJudgment().getBall());

		// case 5
		int[] inputData5 = {9, 1, 3};
		BallCountJudgment judgment5 = new BallCountJudgment(inputData5, answer);
		judgment5.judgeBallCount();

		assertEquals(1, judgment5.getBallCountJudgment().getStrike());
		assertEquals(1, judgment5.getBallCountJudgment().getBall());

		// case 6
		int[] inputData6 = {2, 9, 3};
		BallCountJudgment judgment6 = new BallCountJudgment(inputData6, answer);
		judgment6.judgeBallCount();

		assertEquals(1, judgment6.getBallCountJudgment().getStrike());
		assertEquals(1, judgment6.getBallCountJudgment().getBall());
	}

	@Test
	void threeBall() {
		Answer answer = new Answer(1, 2, 3);

		int[] inputData1 = {2, 3, 1};
		BallCountJudgment judgment1 = new BallCountJudgment(inputData1, answer);
		judgment1.judgeBallCount();

		assertEquals(0, judgment1.getBallCountJudgment().getStrike());
		assertEquals(3, judgment1.getBallCountJudgment().getBall());
	}

	@Test
	void twoBall() {
		Answer answer = new Answer(1, 2, 3);

		// case 1
		int[] inputData1 = {2, 3, 9};
		BallCountJudgment judgment1 = new BallCountJudgment(inputData1, answer);
		judgment1.judgeBallCount();

		assertEquals(0, judgment1.getBallCountJudgment().getStrike());
		assertEquals(2, judgment1.getBallCountJudgment().getBall());

		// case 2
		int[] inputData2 = {2, 9, 1};
		BallCountJudgment judgment2 = new BallCountJudgment(inputData2, answer);
		judgment2.judgeBallCount();

		assertEquals(0, judgment2.getBallCountJudgment().getStrike());
		assertEquals(2, judgment2.getBallCountJudgment().getBall());

		// case 3
		int[] inputData3 = {9, 3, 1};
		BallCountJudgment judgment3 = new BallCountJudgment(inputData3, answer);
		judgment3.judgeBallCount();

		assertEquals(0, judgment3.getBallCountJudgment().getStrike());
		assertEquals(2, judgment3.getBallCountJudgment().getBall());
	}

	@Test
	void oneBall() {
		Answer answer = new Answer(1, 2, 3);

		// case 1
		int[] inputData1 = {8, 3, 9};
		BallCountJudgment judgment1 = new BallCountJudgment(inputData1, answer);
		judgment1.judgeBallCount();

		assertEquals(0, judgment1.getBallCountJudgment().getStrike());
		assertEquals(1, judgment1.getBallCountJudgment().getBall());

		// case 2
		int[] inputData2 = {8, 9, 1};
		BallCountJudgment judgment2 = new BallCountJudgment(inputData2, answer);
		judgment2.judgeBallCount();

		assertEquals(0, judgment2.getBallCountJudgment().getStrike());
		assertEquals(1, judgment2.getBallCountJudgment().getBall());

		// case 3
		int[] inputData3 = {2, 8, 9};
		BallCountJudgment judgment3 = new BallCountJudgment(inputData3, answer);
		judgment3.judgeBallCount();

		assertEquals(0, judgment3.getBallCountJudgment().getStrike());
		assertEquals(1, judgment3.getBallCountJudgment().getBall());
	}

	@Test
	void nothing() {
		Answer answer = new Answer(1, 2, 3);

		int[] inputData = {4, 5, 6};
		BallCountJudgment judgment1 = new BallCountJudgment(inputData, answer);
		judgment1.judgeBallCount();

		assertEquals(0, judgment1.getBallCountJudgment().getStrike());
		assertEquals(0, judgment1.getBallCountJudgment().getBall());
	}
}
