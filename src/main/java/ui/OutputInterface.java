package ui;

import java.io.PrintStream;

public class OutputInterface {
  private PrintStream out;

  public OutputInterface(PrintStream out) {
    this.out = out;
  }

  public void setPrintStream(PrintStream out) {
    this.out = out;
  }

  public void print(String msg) {
    out.print(msg);
  }

  public void println(String msg) {
    out.println(msg);
  }
}
