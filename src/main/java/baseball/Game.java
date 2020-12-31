package baseball;

import java.util.HashSet;
import java.util.Scanner;

public class Game {
    static boolean checkNum(int randNum, HashSet<Integer> choosedNum){
        return (randNum != 0) && (!choosedNum.contains(randNum));
    }
    static int chooseNumber(HashSet<Integer> choosedNum){
        boolean find = false;
        int randNum;

        do {
            randNum = (int)(Math.random()*10);
            find = checkNum(randNum, choosedNum);
        } while(!find);

        return randNum;
    }

    static int[] makeNumbers(){
        int result[] = new int[3];
        HashSet<Integer> choosedNum = new HashSet<>();

        for(int idx = 0; idx < 3; idx++){
            result[idx] = chooseNumber(choosedNum);
            choosedNum.add(result[idx]);
        }

        return result;
    }

    static int checkEqual(int num1, int num2){
        if(num1 == num2)
            return 1;
        return 0;
    }

    static int countStrike(int[] computer, int[] user){
        int count = 0;

        for(int i = 0; i < 3; i++){
            count += checkEqual(computer[i], user[i]);
        }

        return count;
    }

    static int checkWith(int idx, int[] computer, int[] user){
        int count = 0;

        count += checkEqual(computer[idx], user[(idx+1)%3]);
        count += checkEqual(computer[idx], user[(idx+2)%3]);

        return count;
    }

    static int countBall(int[] computer, int[] user){
        int count = 0;
        for(int i = 0; i<3; i++){
            count += checkWith(i, computer, user);
        }
        return count;
    }

    static int[] getUserNum(int input){
        int[] user = new int[3];

        user[0] = input / 100;
        input %= 100;
        user[1] = input / 10;
        user[2] = input % 10;

        return user;
    }
    static boolean printResult(int[] computer, int[] user){
        int strike = countStrike(computer, user);
        int ball = countBall(computer, user);
        if(strike == 3){
            System.out.println(strike + " 스트라이크");
            return false;
        }
        if(strike == 0 && ball == 0)  System.out.print("낫싱");
        if(strike > 0) System.out.print(strike + " 스트라이크 ");
        if(ball > 0) System.out.print(ball + " 볼");
        System.out.println();
        return true;
    }
    static int doGame(int[] computer){
        Scanner scan = new Scanner(System.in);
        int input;
        int[] user;
        boolean flag;
        do{
            System.out.print("숫자를 입력해주세요 : ");
            input = scan.nextInt();
            user = getUserNum(input);
            flag = printResult(computer, user);
        } while(flag);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scan.nextInt();
    }
    public static void main(String[] args){
        System.out.println("start game");
        int flag;

        do {
            int[] computer = makeNumbers();
            flag = doGame(computer);
        }while(flag == 1);

        System.out.println("end game");
    }
}
