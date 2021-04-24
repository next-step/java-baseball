package player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import number.BaseballNumbers;
import number.RandomGenerationStrategy;

public class ComputerTest {
	
	private Player computer;
	
	@BeforeEach
	void setIp() {
		computer = new Computer(RandomGenerationStrategy.getInstance());		
	}	
	
	@Test
	@DisplayName("baseballNumbers이 발생하였는지 테스트")
	public void generateNumbers() {
		computer.generateNumbers();
		assertThat(computer.getNumbers()).isExactlyInstanceOf(BaseballNumbers.class).isNotNull();
	}
}
