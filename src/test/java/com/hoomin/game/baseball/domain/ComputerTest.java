package com.hoomin.game.baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ComputerTest {

	@Test
	public void makeRightNumbers_Void_GetNumbers() {
		Computer computer = new Computer();
		assertThat(computer.makeRightNumbers()).isInstanceOf(Numbers.class);
	}
}
