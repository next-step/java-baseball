package me.right42.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import me.right42.generator.FixedBallNumberGenerator;

class ComputerTest {

	@Test
	void generateTest(){
		Computer computer = new Computer(new FixedBallNumberGenerator("123"));
		BallNumbers ballNumbers = BallNumbers.create("123");

		BallNumbers question = computer.getQuestion();

		assertThat(question).isEqualTo(ballNumbers);
	}

}