import java.util.Scanner;

public class GameDialogue {
    private static final Scanner scanner = new Scanner(System.in);

    public String requestGuess(){
        System.out.print("숫자를 입력해주세요: ");
        String input = scanner.next();
        return input;
    }

    public void printGuessResult(int strikes, int balls){
        if (strikes > 0){
            System.out.print(strikes + "스트라이크 ");
        }
        if (balls > 0){
            System.out.print(balls + "볼 ");
        }
        if (strikes + balls == 0){
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public void printEndGame(int guesses){
        System.out.println(guesses + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean askNewGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.next();
        return input.equals("1");
    }
}
