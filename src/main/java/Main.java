import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean restartFlag = false;
        System.out.println("게임을 시작하겠습니다");
        do {
            Baseball.run();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 아무 메시지를 입력하세요.");
            restartFlag = ("1" == scanner.next());
        } while(restartFlag);
        System.out.println("종료하였습니다");
    }
}
