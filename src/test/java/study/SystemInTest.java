package study;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class SystemInTest {

	@Test
	public void testCase1() {
		String data = "Hello, World!";
		InputStream stdin = System.in;
		try {
			System.setIn(new ByteArrayInputStream((data + "\r\n").getBytes()));
			Scanner scanner = new Scanner(System.in);
			String result = scanner.nextLine();

			assertThat(result).isEqualTo(data);
		} finally {
			System.setIn(stdin);
		}

	}
}
