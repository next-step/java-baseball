package ui;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class OutputInterfaceTest {
  @Test
  @DisplayName("Basic output test")
  void printStringTest() {
    ByteArrayOutputStream captor = new ByteArrayOutputStream();
    OutputInterface out = new OutputInterface(new PrintStream(captor));

    out.printString("lorem ipsum...");
    assertThat(captor.toString().trim()).isEqualTo("lorem ipsum...");
  }
}
