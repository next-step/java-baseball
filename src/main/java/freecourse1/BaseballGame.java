package freecourse1;

import java.util.Scanner;

public class BaseballGame {

    private Scanner scanner;
    private GamerNumber gamerNumber;
    private RandomNumber randomNumber;
    private Score score;

    private int[] makeNumbers;
    private int[] inputNumbers;

    public BaseballGame() {
        scanner = new Scanner(System.in);
        gamerNumber = new GamerNumber();
        randomNumber = new RandomNumber();
        score = new Score();
    }

    public void play(){
        scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        readInputNumbers();
        makeRandomNumbers();
        checkCompare();
    }

    private void readInputNumbers(){
        gamerNumber.read(scanner.next());
        inputNumbers = gamerNumber.getNumbers();
    }

    private void makeRandomNumbers(){
        randomNumber.make();
        makeNumbers = randomNumber.getNumbers();

        String sNumbers = "";
        for(int i=0; i<3; i++){
            sNumbers = sNumbers.concat(String.valueOf(makeNumbers[i]));
        }
        System.out.println("makeNumbers : "+sNumbers);
    }

    private void checkCompare(){
        score.compare(makeNumbers,inputNumbers);
        System.out.println(score.getScore());
    }

}
