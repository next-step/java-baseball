package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BaseballNumberTest {

	@Test
	public void 일의자리수에0을대입하려고하면에러() {
		assertThrows(RuntimeException.class, () -> {
			new BaseballNumber(0, 1, 2);
		});
	}

	@Test
	public void 십의자리수에0을대입하려고하면에러() {
		assertThrows(RuntimeException.class, () -> {
			new BaseballNumber(1, 0, 2);
		});
	}

	@Test
	public void 백의자리수에0을대입하려고하면에러() {
		assertThrows(RuntimeException.class, () -> {
			new BaseballNumber(1, 2, 0);
		});
	}
}
