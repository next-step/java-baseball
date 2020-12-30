/*
 * BaseBall
 *
 * 0.2
 *
 * 2020.12.28
 *
 * 저작권 주의 by huey.j
 */

package baseball;

import java.util.Scanner;

public class BaseBall {
    int[] com_num = new int[3];
    int[] user_num = new int[3];
    boolean[] used_num = new boolean[10];
    boolean end;
    boolean error;

    private void init() {
        end = false;
        error = false;

        //숫자의 사용여부 저장 배열
        for(int i=0;i<10;i++)
            used_num[i] = false;

        //컴퓨터의 숫자 3개 랜덤으로 생성
        for(int i=0;i<3;i++){
            com_num[i] = random();
            user_num[i] = 0;
        }

    }

    private int random() {
        int num = (int) (Math.random() * 9 + 1);  // 1 ~ 9까지 수를 랜덤으로 생성

        while(used_num[num]){
            num = (int) (Math.random() * 9 + 1);  // 1 ~ 9까지 수를 랜덤으로 생성
        }

        used_num[num] = true;   // num이 사용되었음을 체크

        return num;
    }

    private int parseString() {
        int input;

        Scanner sc = new Scanner(System.in);
        String Sinput = sc.nextLine();

        try {
            input = Integer.parseInt(Sinput);
        } catch (NumberFormatException e) {
            error = true;
            return -1;
        }

        return input;
    }

    private boolean checkError(int input) {
        //3자리 이상인 수 확인
        if(input > 0)
            return true;

        //중복 확인
        return user_num[0] == user_num[1] || user_num[0] == user_num[2] || user_num[1] == user_num[2];
    }

    private void scanNum() {
        int input = parseString();

        for(int i=2;i>=0;i--){
            user_num[i] = input % 10;
            input /= 10;
        }

        if(checkError(input)) {
            error = true;
        }

    }

    private int getStrike() {
        int strike = 0;

        if(com_num[0] == user_num[0])
            strike++;
        if(com_num[1] == user_num[1])
            strike++;
        if(com_num[2] == user_num[2])
            strike++;

        return strike;
    }

    private int getBall() {
        int ball = 0;

        if(user_num[0] == com_num[1] || user_num[0] == com_num[2])
            ball++;
        if(user_num[1] == com_num[0] || user_num[1] == com_num[2])
            ball++;
        if(user_num[2] == com_num[0] || user_num[2] == com_num[1])
            ball++;

        return ball;
    }


}
