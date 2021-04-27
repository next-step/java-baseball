package freecourse1;

import java.util.Scanner;

public class BaseballGame {

    private Scanner scanner;
    private GamerNumber gamerNumber;
    boolean bExit = true;

    public BaseballGame() {
        scanner = new Scanner(System.in);
        gamerNumber = new GamerNumber();
    }

    public void play(){
        scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        read();
    }

    private void read(){
        gamerNumber.read(scanner.next());
        int[] numbers = gamerNumber.getNumbers();
        for(int i=0; i<3; i++){
            System.out.println(numbers[i]);
        }
    }

}
