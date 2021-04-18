import java.util.Scanner;

public class BaseballGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInput userInput = new UserInput();
        MakeRandomNumber makeRandomNumber = new MakeRandomNumber();


//        Integer input = userInput.setAndGetInputNumber();

        Integer menu = 0;
//        String answer;
        Integer randomNumber = makeRandomNumber.getNewRandomNumber();

        while (menu != 2){
            Integer input = userInput.setAndGetInputNumber();
            GameLogic gameLogic = new GameLogic(randomNumber,input);
            String answer = gameLogic.getAnswer();
            System.out.println(answer);
            if("3스트라이크".equals(answer) == true){
                randomNumber = makeRandomNumber.getNewRandomNumber();
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"+"\n"+"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                menu = scanner.nextInt();
            }

        }
    }
}
