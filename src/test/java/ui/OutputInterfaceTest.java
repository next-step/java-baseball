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

    out.print("lorem ipsum...");
    assertThat(captor.toString()).isEqualTo("lorem ipsum...");

    captor.reset();
    out.println("lorem ipsum...");
    assertThat(captor.toString()).isEqualTo("lorem ipsum...\r\n");
  }
}
