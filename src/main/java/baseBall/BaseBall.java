package baseBall;

import baseBall.util.CreateNumber;
import baseBall.util.Discrimination;
import baseBall.util.InputUserNumber;

import java.util.Scanner;

public class BaseBall {

    private String userNumber = "";
    private String systemNumber = "";

    public void run() {

        String gameResult = "";
        Discrimination discrimination = new Discrimination();

        systemNumber = new CreateNumber().generateNumbers();

        while(true) {

            gameStart();

            gameResult = discrimination.match(systemNumber, userNumber);

            if(discrimination.checkVictory()) {
                confirmContinue();
                break;
            };

            System.out.println(gameResult);
        }

    }


    public void gameStart() {

        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요.");

        userNumber = sc.next();

        InputUserNumber inputUserNumber = new InputUserNumber(userNumber);

    }

    public void confirmContinue() {
        System.out.println("게임에 승리하셨습니다. 계속 하시려면 1을 종료하시려면 2를 입력해주세요.");

        Scanner sc = new Scanner(System.in);
        String answer = sc.next();

        if(answer.equals("1")) {
            run();
        }

    }


}
