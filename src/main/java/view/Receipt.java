package view;

import domain.Numbers;
import domain.ReplayNumber;

import java.util.Scanner;

public class Receipt {

    public static boolean receiveValueWhetherToEndGameOrNot() {
        Scanner scanner = makeScanner();
        int valueOfReplay = scanner.nextInt();
        return ReplayNumber.valueOf(valueOfReplay);
    }

    public static Numbers receiptNumber() {
        Scanner scanner = makeScanner();
        return new Numbers(scanner.nextLine());
    }

    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }
}
