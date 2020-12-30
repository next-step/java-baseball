import java.util.*;

public class BaseBallGame {

    static private Scanner sc;
    static private final int MAX_LENGTH=3;

    public void runBaseBallGame(){

        sc=new Scanner(System.in);
        while (isStart()) {

        }

    }



    private boolean isStart(){

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String startInput=sc.nextLine();
        while (!validateStartInput(startInput)) {
            startInput=sc.nextLine();
        }

        return checkStartInput(startInput);
    }

    private boolean validateStartInput(String startInput){

        if(startInput.equals("1")||startInput.equals("2")){
            return true;
        }
        System.out.println("잘못된 입력입니다.");
        return false;
    }

    private boolean checkStartInput(String startInput){

        if(startInput.equals("1")){
            return true;
        }
        return false;
    }

}


