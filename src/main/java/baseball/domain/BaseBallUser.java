package baseball.domain;

import java.util.Scanner;

public class BaseBallUser {
    private String userNum = "";

    public String getUserCreateNum(){
        return userNum;
    }

    protected void userSelectNum(){
        boolean check = true;
        String number = "";
        while(check){
            number = userCreateNum();
            //check = userCreateNumCheck(number);
        }
        userNum = number;
    }

    private String userCreateNum(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String number = sc.nextLine();
        return number;
    }
}
