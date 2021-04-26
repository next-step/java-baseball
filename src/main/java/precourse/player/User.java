package precourse.player;

import java.util.Scanner;

public class User {

    private final Scanner scanner = new Scanner(System.in);

    public String answer() {
        return scanner.next();
    }

}
