/**
 * Main.java
 * 2020년 12월 26일 생성
 * 아무 제약 없이 사용할 수 있는 소스코드입니다
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean restartFlag;
        System.out.println("게임을 시작하겠습니다");
        do {
            Baseball.run();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 아무 메시지를 입력하세요.");
            restartFlag = (scanner.next().equals("1"));
        } while(restartFlag);
        System.out.println("종료하였습니다");
    }
}
