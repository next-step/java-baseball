import java.util.Scanner;

public class BaseballGameView {

    private final Scanner scanner = new Scanner(System.in);

    //숫자 입력
    public String getUserNumber(){
        System.out.println("숫자를 입력해주세요 : ");

        return scanner.next();
    }

    //Result 출력
    public void printGameResult(String message){
        System.out.println(message);
    }

    //게임 재진행/종료 유무 출력
    public String getGameRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return scanner.next();
    }

}
