import java.util.Scanner;

public class BaseBallGame {

    static private Scanner sc;

    public void runBaseBallGame(){

        sc=new Scanner(System.in);


    }

    private boolean isStart(){

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String startInput=sc.nextLine();
        return true;
    }



}


