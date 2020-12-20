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
        System.out.println(sb.toString());
    }
}
