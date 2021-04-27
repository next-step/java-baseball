package com.hoomin.game.baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class QuizTest {

	@ParameterizedTest
	@ValueSource(ints = {3})
	public void isSolved_strikeCountIs3_returnTrue(int strikeCount) {
		Quiz quiz = new Quiz(new Numbers(Arrays.asList(1,2,3)));
		assertThat(quiz.isSolved(strikeCount)).isEqualTo(true);
	}

	@ParameterizedTest
	@ValueSource(ints = {4})
	public void isSolved_strikeCountMoreThen3_returnFalse(int strikeCount) {
		Quiz quiz = new Quiz(new Numbers(Arrays.asList(1,2,3)));
		assertThat(quiz.isSolved(strikeCount)).isEqualTo(false);
	}
}
