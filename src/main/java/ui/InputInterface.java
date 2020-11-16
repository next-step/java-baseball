package ui;

import java.util.Scanner;
import java.io.InputStream;

public class InputInterface {
  private InputStream in;
  private Scanner scanner;

  public InputInterface(InputStream in) {
    this.in = in;
    scanner = new Scanner(this.in);
  }

  public void setInputStream(InputStream in) {
    this.in = in;
  }

  public String getInput() {
    return scanner.nextLine().trim();
  }

  public void close() {
    if (scanner != null) {
      scanner.close();
    }
  }
}
