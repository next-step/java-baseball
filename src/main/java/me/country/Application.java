package me.country;

import java.util.Scanner;
import me.country.component.Computer;

public final class Application {

  public static void main(String[] args) {
    Computer computer = new Computer();
    Scanner scanner = new Scanner(System.in);

    boolean ing = true;
    while (ing) {
      int inputNumber = scanner.nextInt();
      computer.calc(inputNumber);
      computer.print();
      ing = computer.isIng(inputNumber);
    }
  }
}
