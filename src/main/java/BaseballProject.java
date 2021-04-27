import java.util.Scanner;

public class BaseballProject {

    boolean isCorrect; // 정답확인 여부
    boolean isContinue = true; // 계속진행 여부

    // TODO : 게임 실행 메서드
    public static void playGame(BaseballProject project, BaseBallGame baseBallGame){
        while(!project.isCorrect){
            Scanner scanner = new Scanner(System.in);
            // TODO : 1. input user answer
            System.out.println("숫자를 입력해주세요");
            String userAnswer = scanner.next();

            // TODO : 2. check user' Answer & show resultMessage
            checkGame(baseBallGame, userAnswer, project);
        }
    }

    // TODO : 게임 결과 확인 후 진행 로직
    public static void checkGame(BaseBallGame baseBallGame, String userAnswer, BaseballProject project){

        // TODO : 2. check user' Answer & show resultMessage
        int result = baseBallGame.checkAnswer(userAnswer);
        String resultMessage = baseBallGame.makeResultMessage(baseBallGame.checkResultModel);
        System.out.println(resultMessage);
        baseBallGame.resetModel(baseBallGame.checkResultModel);

        // TODO : 3. control isContinue to restart or stop game
        endGame(result, project);
    }

    // TODO : 게임 종료 여부 확인 후, 종료/재시작 조치
    public static void endGame(int result, BaseballProject project){
        if(result == 1){
            project.isCorrect = true;
            System.out.println("게임을 새로 시작하시려면 1, 아니면 2를 입력해주세요");
            Scanner scanner = new Scanner(System.in);
            String willContinue = scanner.next();
            stopGame(willContinue, project);
        }
    }

    // TODO : 게임 종료 의사 확인 후, 종료
    public static void stopGame(String willContinue, BaseballProject project){
        if(willContinue.equals("2") ){
            project.isContinue = false;
            System.out.println("게임이 종료되었습니다.");
        }
    }

    public static void main(String [] args){

        BaseballProject project = new BaseballProject();
        project.isCorrect = false;
        while(project.isContinue){

            System.out.println("게임을 시작합니다.");

            // TODO : 0. init
            project.isCorrect = false;
            BaseBallGame baseBallGame = new BaseBallGame();
            baseBallGame.init();
            System.out.println("target : " + baseBallGame.targetNumberList.get(0) + baseBallGame.targetNumberList.get(1) + baseBallGame.targetNumberList.get(2));
            playGame(project, baseBallGame);
        }
    }
}
