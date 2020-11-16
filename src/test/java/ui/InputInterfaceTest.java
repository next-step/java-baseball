package ui;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class InputInterfaceTest {
  @Test
  @DisplayName("Basic input test")
  void getInputTest() {
    String srcString = new String("lorem ipsum...");
    ByteArrayInputStream source = new ByteArrayInputStream(srcString.getBytes());
    InputInterface in = new InputInterface(source);

    assertThat(in.getInput().trim()).isEqualTo("lorem ipsum...");
  }
}
