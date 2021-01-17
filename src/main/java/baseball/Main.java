package baseball;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Computer cp = new Computer();
        Scanner sc = new Scanner(System.in);

        boolean ing = true;
        while (ing) {
            int inputNumber = sc.nextInt();
            cp.calc(inputNumber);
            cp.print();
            ing = cp.isIng(inputNumber);
        }
    }
}