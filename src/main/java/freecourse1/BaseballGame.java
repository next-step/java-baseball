package freecourse1;

import java.util.Scanner;

public class BaseballGame {

    private Scanner scanner;
    private GamerNumber gamerNumber;
    private RandomNumber randomNumber;
    private Score score;

    private int[] makeNumbers;
    private int[] inputNumbers;
    boolean bExit = true;

    public BaseballGame() {
        scanner = new Scanner(System.in);
        gamerNumber = new GamerNumber();
        randomNumber = new RandomNumber();
        score = new Score();
    }

    public void play(){
        bExit = true;
        makeRandomNumbers();

        while(bExit) {
            System.out.print("숫자를 입력해주세요 : ");
            readInputNumbers();
            checkCompare();
            checkExit();
        }
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

    private void checkExit(){
        if(score.isSuccess()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.print("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요. ");
            if(scanner.nextInt() == 1) {
                makeRandomNumbers();  // 랜덤숫자를 다시 생성해야한다.
            }else {
                bExit = false;
            }
        }
    }

}
