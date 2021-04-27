import java.util.Scanner;

public class BaseballProject {

    public static void main(String [] args){

        boolean isCorrect; // 정답확인 여부
        boolean isContinue = true; // 계속진행 여부

        while(isContinue){

            System.out.println("게임을 시작합니다.");

            // TODO : 0. init
            BaseBallGame baseBallGame = new BaseBallGame();
            baseBallGame.init();
            isCorrect = false;
//            System.out.println("target : " + baseBallGame.targetNumberArray.get(0) + baseBallGame.targetNumberArray.get(1) + baseBallGame.targetNumberArray.get(2));
            Scanner scanner = new Scanner(System.in);
            while(!isCorrect){

                // TODO : 1. input user answer
                System.out.println("숫자를 입력해주세요");
                String userAnswer = scanner.next();

                // TODO : 2. check user' Answer & show resultMessage
                int result = baseBallGame.checkAnswer(userAnswer);
                String resultMessage = baseBallGame.makeResultMessage(baseBallGame.checkResultModel);
                System.out.println(resultMessage);
            }
        }
    }
}
