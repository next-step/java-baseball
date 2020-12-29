import java.util.Random;
import java.util.Scanner;

public class main {

    public static Scanner sc = new Scanner(System.in);
    public static boolean used[] = new boolean[10];
    public static int answer[] = {0, 0, 0};
    public static int strike = 0;
    public static int ball = 0;
    public static void main(String[] args) {
        makeAnswerRandom();
        problem();
    }

    public static void problem(){
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String num = sc.next();

            isAnswer(num);
            ball = 0;
            strike = 0;
        }

    }

    public static boolean showMenu(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int num = sc.nextInt();

        if(num == 1)
            return true;

        return false;
    }

    public static void makeAnswerRandom(){
        for(int i=0; i<3; i++){
            answer[i] = getRandomNumber();
            used[answer[i]] = true;
        }
    }

    public static int getRandomNumber(){
        Random random = new Random();
        int number = random.nextInt(9)+1;
        while(used[number]){
            number = random.nextInt(9)+1;
        }
        return number;
    }

    public static boolean isAnswer(String num){
        for(int i=0; i<3; i++){
            isStrikeOrBall(i, num);
        }

        if(strike != 0)
            System.out.print(strike+"스트라이크 ");

        if(ball != 0)
            System.out.print(ball+"볼");

        if(strike == 0 && ball == 0)
            System.out.print("일치하는 숫자가 없습니다.");

        System.out.println();
        if(strike == 3)
            return true;

        return false;
    }

    public static void isStrikeOrBall(int n, String num){
        if(num.charAt(n) - '0' == answer[n]){
            strike++;
            return;
        }

        if(used[num.charAt(n) - '0']) {
            ball++;
            return ;
        }
    }
}
