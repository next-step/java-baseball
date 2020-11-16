package com.nextstep.example.model;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RefereeTest {

	private final OutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	private Referee referee;

	@BeforeEach
	protected void setUp() throws Exception {
		referee = new Referee();
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	protected void teerDown() throws Exception {
		System.setOut(originalOut);
	}

	@DisplayName("스트라이크 판정 확인")
	@Test
	public void testGetJudgeStrike() throws Exception {
		referee.getJudge("123", "123");
		assertThat(outContent.toString()).asString().startsWith("3 스트라이크");
	}

	@DisplayName("볼 판정 확인")
	@Test
	public void testGetJudgeBall() throws Exception {
		referee.getJudge("123", "345");
		assertThat(outContent.toString()).asString().startsWith("1 볼");
	}

	@DisplayName("스크라이크 & 볼 판정 확인")
	@Test
	public void testGetJudgeStrikeAndBall() throws Exception {
		referee.getJudge("123", "142");
		assertThat(outContent.toString()).asString().startsWith("1 스트라이크 1 볼");
	}

	@DisplayName("낫싱 판정 확인")
	@Test
	public void testGetJudgeNothing() throws Exception {
		referee.getJudge("123", "456");
		assertThat(outContent.toString()).asString().startsWith("낫싱");
	}

}
