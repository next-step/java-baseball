import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {
    private int targetNumber;
    Scanner sc = new Scanner(System.in);

    public int getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(int targetNumber){this.targetNumber = targetNumber; }

    public int makeTagetNumber(){
        Random random= new Random();
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        do {
            set.add(random.nextInt(9) + 1);
        } while (set.size() < 3);

        for (Integer integer : set) {
            result = result * 10 + integer;
        }
        return result;

    }

    public void newGameStart(){
        int tmp;
        do{
            play();
            System.out.println("다시 게임을 하시려면 1 입력, 종료하시려면 2 입력");

            tmp = sc.nextInt();
        }while(tmp == 1);
    }

    private void play(){
        this.targetNumber = makeTagetNumber();
        System.out.println(this.targetNumber);
        while(true){
            System.out.print("숫자를 입력해주세요: ");
            if(isMatch(sc.nextInt())){
                System.out.println("세개의 숫자를 모두 맞히셨습니다!게임종료");
                break;
            }
        }
    }
    public boolean isMatch(int number){
        if(!checkInputNumber(number)){
            System.out.println("잘못된 입력입니다");
            return false;
        }

        int strikeCount = strikeCount(number);
        int ballCount = ballCount(number, strikeCount);

        printScore(strikeCount, ballCount);

        return strikeCount == 3;

    }
    public boolean checkInputNumber(int number){
        if(number >= 1000 || number < 100){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 3; i++){
            set.add((number / (int)(Math.pow(10, i))) % 10);
        }

        return set.size() == 3;
    }

    public int strikeCount(int number){
        int result = 0;
        for(int i = 0; i < 3; i++){
            if(((int)(this.targetNumber / (int)(Math.pow(10, i))) % 10) == ((int)(number / (int)(Math.pow(10, i))) % 10)){
                result++;
            }
        }
        return result;
    }

    public int ballCount(int number, int strikeCount){
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < 3; i++){
            set.add((this.targetNumber / (int)(Math.pow(10, i))) % 10);
            set.add((number / (int)(Math.pow(10, i))) % 10);
        }
        return 6 - set.size() - strikeCount;
    }

    private void printScore(int strikeCount, int ballCount){
        if(strikeCount > 0)
            System.out.print(strikeCount + "스트라이크");

        if(ballCount > 0){
            System.out.println(ballCount + "볼");
            return;
        }
        if(strikeCount == 0 && ballCount == 0){
            System.out.println("낫싱");
            return;
        }
        System.out.println();

    }



}
