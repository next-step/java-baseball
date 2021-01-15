package features;

import io.PrintOutput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PrintResultTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Test nothing is print out correctly")
    public void checkResultTest() {
        PrintOutput printOutput = new PrintOutput();
        PrintResult.checkResult(0, 0, printOutput);
        assertEquals("낫싱\n", outContent.toString());
    }

    @Test
    @DisplayName("Test Strike is print out correctly")
    public void checkResultTest2() {
        PrintOutput printOutput = new PrintOutput();
        PrintResult.checkResult(2, 0, printOutput);
        assertEquals("2스트라이크\n", outContent.toString());
    }

    @Test
    @DisplayName("Test Ball is print out correctly")
    public void checkResultTest3() {
        PrintOutput printOutput = new PrintOutput();
        PrintResult.checkResult(0, 2, printOutput);
        assertEquals("2볼\n", outContent.toString());
    }

    @Test
    @DisplayName("Test Strike is print out correctly")
    public void checkResultTest4() {
        PrintOutput printOutput = new PrintOutput();
        PrintResult.checkResult(2, 1, printOutput);
        assertEquals("1볼 2스트라이크\n", outContent.toString());
    }

}