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
	@DisplayName("플레이어 숫자 입력 테스트")
	public void inputNumberTest() throws Exception {
		String invalidValue = "0";
		int length = 3;
		
		Set<Integer> inputNumberSet = player.putThreeDigitNumber(invalidValue, length); // 콘솔에 값 입력 요망
		assertThat(inputNumberSet.size()).isEqualTo(3);
	}
}
