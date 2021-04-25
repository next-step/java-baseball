package domainTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import domain.Numbers;
import domain.participants.Umpire;
import view.Message;
import view.OutputMessage;

public class UmpireTest {



	@DisplayName("심판의 판정로직 테스트 : Case 1. 낫씽")
	@Test
	void makeJudgement_AnswerGuessAllDifferent_ResultShouldBeNothing(){


		//Given
		Numbers answer = new Numbers();
		Numbers guess = new Numbers();
		Umpire umpire = new Umpire();

		//When
		answer.add(4);
		answer.add(5);
		answer.add(6);
		guess.add(1);
		guess.add(2);
		guess.add(3);

		umpire.makeJudgement(answer,guess);

		//Then
		assertThat(umpire.getBall() == 0 && umpire.getStrike() == 0).isEqualTo(true);
	}

	@DisplayName("심판의 판정로직 테스트 : Case 2. Ball")
	@Test
	void makeJudgement_AnswerGuessBall_ResultOneBall(){
		//Given
		Numbers answer = new Numbers();
		Numbers guess = new Numbers();
		Umpire umpire = new Umpire();

		//When
		answer.add(4);
		answer.add(5);
		answer.add(6);

		guess.add(5);
		guess.add(6);
		guess.add(7);

		umpire.makeJudgement(answer,guess);

		//Then
		assertThat(umpire.getBall()).isEqualTo(2);
	}

	@DisplayName("심판의 판정로직 테스트 : Case 3. Strike")
	@Test
	void makeJudgement_AnswerGuessStrike_ResultTwoStrike(){
		//Given
		Numbers answer = new Numbers();
		Numbers guess = new Numbers();
		Umpire umpire = new Umpire();

		//When
		answer.add(4);
		answer.add(5);
		answer.add(6);

		guess.add(4);
		guess.add(5);
		guess.add(9);

		umpire.makeJudgement(answer,guess);

		//Then
		assertThat(umpire.getStrike()).isEqualTo(2);
	}

	@DisplayName("다음 라운드 진행여부 물어볼 때, score 초기화")
	@Test
	void askAnotherRound_initAllScores(){
		//Given
		Numbers answer = new Numbers();
		Numbers guess = new Numbers();
		Umpire umpire = new Umpire();
		answer.add(4);
		answer.add(5);
		answer.add(6);

		guess.add(4);
		guess.add(9);
		guess.add(9);

		umpire.makeJudgement(answer,guess);

		//When
		umpire.askAnotherRound();

		//Then
		assertThat(umpire.getBall() == 0 && umpire.getStrike() == 0).isEqualTo(true);
	}
}
