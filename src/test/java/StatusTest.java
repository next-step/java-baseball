
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class StatusTest {
	@BeforeEach
	void setUp() {
	}
	
	public enum Status{
		S("��Ʈ����ũ"),
		B("��");
		
		private String status; 
		
		Status(String status){
			this.status = status;
		}
		
		public static String findStatus(String arg) {
			for(Status st : Status.values()) {
				if(st.name().equals(arg)) {
					return st.status;
				}
			}
			return "";
		}
		
	}
	
	@Test
	@ParameterizedTest
	@ValueSource(strings = {"S","B","N"})
	@DisplayName("����,���¸� ����")
	void enumTest(String input) {
		assertTrue(Status.findStatus(input).isEmpty());
	}
	
}
