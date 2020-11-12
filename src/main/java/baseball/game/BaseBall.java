package baseball.game;

import baseball.computer.Computer;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class BaseBall {

  private final Computer computer;

  private final Scanner scanner;

  public BaseBall() {
    this.computer = new Computer();
    this.scanner = new Scanner(System.in);
  }

  private LinkedHashSet<Integer> getComputerBalls() {
    return this.computer.getBalls();
  }



}
