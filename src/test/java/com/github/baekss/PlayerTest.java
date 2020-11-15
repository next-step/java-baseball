package com.github.baekss;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.baekss.domain.JoinStatus;
import com.github.baekss.domain.Player;

public class PlayerTest {

	private Player player;
	
	@BeforeEach
	public void createPlayer() {
		this.player = Player.createPlayer(JoinStatus.JOIN);
	}
	
	@Test
	@DisplayName("플레이어 상태 테스트")
	public void playerGameJoinTest() {
		assertThat(player).extracting("status").isEqualTo(JoinStatus.JOIN);
	}
	
	@Test
	@DisplayName("플레이어의 입력값 반환 테스트")
	public void outputNumberTest() throws Exception {
		String threeDigitNumberString = "726";
		
		Set<Integer> outputNumberSet = player.getThreeDigitNumber(threeDigitNumberString);
		assertThat(outputNumberSet.size()).isEqualTo(3);
	}
}
