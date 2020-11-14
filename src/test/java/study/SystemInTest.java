package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.mock.MockScanner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
