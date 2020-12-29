package baseball;

import java.util.*;

public class Baseball {
    public Scanner sc = new Scanner(System.in);
    public int flag;

    public void playBall() {
        flag = 1;

        while (flag == 1) {
            setFlag();
        }
    }

    public void setFlag() {
        boolean isOk = false;

        while (!isOk) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            flag = sc.nextInt();
            isOk = (flag == 1 || flag == 2) ? true : false;
        }
    }
}
