import java.util.Scanner;

public class BaseballView {

    private final Scanner scanner = new Scanner(System.in);

    public String viewInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }

    public void viewStrikeBallCount(int strikeCount, int ballCount) {
        StringBuilder sb = new StringBuilder();
        if(strikeCount > 0){
            sb.append(String.format("%d 스트라이크 ", strikeCount));
        }
        if(ballCount > 0){
            sb.append(String.format("%d볼", ballCount));
        }
        if(sb.length() == 0){
            sb.append("낫싱");
        }
        System.out.println(sb.toString());
    }

    public String viewCorrectResult(int lengthOfBallNumber) {
        System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", lengthOfBallNumber));
        String input = "";

        while(!input.equals("1") && !input.equals("2")){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = scanner.nextLine();
        }

        return input;
    }
}
