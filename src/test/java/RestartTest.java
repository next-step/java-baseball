
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class RestartTest {
	private String inputStr;
	
	@BeforeEach
	void setUp() {
		inputStr = "1";
	}
	
	@Test
	@DisplayName("���� ����� ���� ����")
	public void restartBaseballGame() {
		assertTrue("1".equals(inputStr));
		assertTrue("2".equals(inputStr));
	}
}
