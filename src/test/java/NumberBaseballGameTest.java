import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import NumberBaseballGame.BallCount;
import NumberBaseballGame.NumberBaseballGame;

class NumberBaseballGameTest {

	@Test
	void threeStrike() {
		BallCount ballCountSum = new BallCount();

		BallCount ballCountAnswer = new BallCount();
		ballCountAnswer.setStrike(3);

		NumberBaseballGame game = new NumberBaseballGame(1, 2, 3);

		int[] inputData = {1, 2, 3};
		ballCountSum = game.judgeBallCount(inputData);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum.getBall());
	}

	@Test
	void twoStrike() {
		BallCount ballCountSum1 = new BallCount();
		BallCount ballCountSum2 = new BallCount();
		BallCount ballCountSum3 = new BallCount();

		BallCount ballCountAnswer = new BallCount();
		ballCountAnswer.setStrike(2);

		NumberBaseballGame game = new NumberBaseballGame(1, 2, 3);

		// case 1
		int[] inputData1 = {1, 2, 9};
		ballCountSum1 = game.judgeBallCount(inputData1);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum1.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum1.getBall());

		// case 2
		int[] inputData2 = {1, 9, 3};
		ballCountSum2 = game.judgeBallCount(inputData2);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum2.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum2.getBall());

		// case 3
		int[] inputData3 = {9, 2, 3};
		ballCountSum3 = game.judgeBallCount(inputData3);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum3.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum3.getBall());
	}

	@Test
	void oneStrike() {
		BallCount ballCountSum1 = new BallCount();
		BallCount ballCountSum2 = new BallCount();
		BallCount ballCountSum3 = new BallCount();

		BallCount ballCountAnswer = new BallCount();
		ballCountAnswer.setStrike(1);

		NumberBaseballGame game = new NumberBaseballGame(1, 2, 3);

		// case 1
		int[] inputData1 = {1, 8, 9};
		ballCountSum1 = game.judgeBallCount(inputData1);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum1.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum1.getBall());

		// case 2
		int[] inputData2 = {8, 2, 9};
		ballCountSum2 = game.judgeBallCount(inputData2);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum2.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum2.getBall());

		// case 3
		int[] inputData3 = {9, 8, 3};
		ballCountSum3 = game.judgeBallCount(inputData3);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum3.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum3.getBall());
	}

	@Test
	void oneStrikeTwoBall() {
		BallCount ballCountSum1 = new BallCount();
		BallCount ballCountSum2 = new BallCount();
		BallCount ballCountSum3 = new BallCount();

		BallCount ballCountAnswer = new BallCount();
		ballCountAnswer.setStrike(1);
		ballCountAnswer.setBall(2);

		NumberBaseballGame game = new NumberBaseballGame(1, 2, 3);

		// case 1
		int[] inputData1 = {1, 3, 2};
		ballCountSum1 = game.judgeBallCount(inputData1);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum1.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum1.getBall());

		// case 2
		int[] inputData2 = {3, 2, 1};
		ballCountSum2 = game.judgeBallCount(inputData2);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum2.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum2.getBall());

		// case 3
		int[] inputData3 = {2, 1, 3};
		ballCountSum3 = game.judgeBallCount(inputData3);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum3.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum3.getBall());
	}

	@Test
	void oneStrikeOneBall() {
		BallCount ballCountSum1 = new BallCount();
		BallCount ballCountSum2 = new BallCount();
		BallCount ballCountSum3 = new BallCount();
		BallCount ballCountSum4 = new BallCount();
		BallCount ballCountSum5 = new BallCount();
		BallCount ballCountSum6 = new BallCount();

		BallCount ballCountAnswer = new BallCount();
		ballCountAnswer.setStrike(1);
		ballCountAnswer.setBall(1);

		NumberBaseballGame game = new NumberBaseballGame(1, 2, 3);

		// case 1
		int[] inputData1 = {1, 3, 9};
		ballCountSum1 = game.judgeBallCount(inputData1);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum1.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum1.getBall());

		// case 2
		int[] inputData2 = {1, 9, 2};
		ballCountSum2 = game.judgeBallCount(inputData2);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum2.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum2.getBall());

		// case 3
		int[] inputData3 = {3, 2, 9};
		ballCountSum3 = game.judgeBallCount(inputData3);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum3.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum3.getBall());

		// case 4
		int[] inputData4 = {9, 2, 1};
		ballCountSum4 = game.judgeBallCount(inputData4);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum4.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum4.getBall());

		// case 5
		int[] inputData5 = {9, 1, 3};
		ballCountSum5 = game.judgeBallCount(inputData5);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum5.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum5.getBall());

		// case 6
		int[] inputData6 = {2, 9, 3};
		ballCountSum6 = game.judgeBallCount(inputData6);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum6.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum6.getBall());
	}

	@Test
	void threeBall() {
		BallCount ballCountSum = new BallCount();

		BallCount ballCountAnswer = new BallCount();
		ballCountAnswer.setBall(3);

		NumberBaseballGame game = new NumberBaseballGame(1, 2, 3);

		int[] inputData1 = {2, 3, 1};
		ballCountSum = game.judgeBallCount(inputData1);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum.getBall());
	}

	@Test
	void twoBall() {
		BallCount ballCountSum1 = new BallCount();
		BallCount ballCountSum2 = new BallCount();
		BallCount ballCountSum3 = new BallCount();

		BallCount ballCountAnswer = new BallCount();
		ballCountAnswer.setBall(2);

		NumberBaseballGame game = new NumberBaseballGame(1, 2, 3);

		// case 1
		int[] inputData1 = {2, 3, 9};
		ballCountSum1 = game.judgeBallCount(inputData1);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum1.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum1.getBall());

		// case 2
		int[] inputData2 = {2, 9, 1};
		ballCountSum2 = game.judgeBallCount(inputData2);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum2.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum2.getBall());

		// case 3
		int[] inputData3 = {9, 3, 1};
		ballCountSum3 = game.judgeBallCount(inputData3);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum3.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum3.getBall());
	}

	@Test
	void oneBall() {
		BallCount ballCountSum1 = new BallCount();
		BallCount ballCountSum2 = new BallCount();
		BallCount ballCountSum3 = new BallCount();

		BallCount ballCountAnswer = new BallCount();
		ballCountAnswer.setBall(1);

		NumberBaseballGame game = new NumberBaseballGame(1, 2, 3);

		// case 1
		int[] inputData1 = {8, 3, 9};
		ballCountSum1 = game.judgeBallCount(inputData1);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum1.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum1.getBall());

		// case 2
		int[] inputData2 = {8, 9, 1};
		ballCountSum2 = game.judgeBallCount(inputData2);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum2.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum2.getBall());

		// case 3
		int[] inputData3 = {2, 8, 9};
		ballCountSum3 = game.judgeBallCount(inputData3);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum3.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum3.getBall());
	}

	@Test
	void nothing() {
		BallCount ballCountSum = new BallCount();
		BallCount ballCountAnswer = new BallCount();

		NumberBaseballGame game = new NumberBaseballGame(1, 2, 3);

		int[] inputData = {4, 5, 6};
		ballCountSum = game.judgeBallCount(inputData);

		assertEquals(ballCountAnswer.getStrike(), ballCountSum.getStrike());
		assertEquals(ballCountAnswer.getBall(), ballCountSum.getBall());
	}

}
