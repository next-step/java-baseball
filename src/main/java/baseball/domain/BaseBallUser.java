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
            check = userCreateNumCheck(number);
        }
        userNum = number;
    }

    private String userCreateNum(){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String number = sc.nextLine();
        return number;
    }

    private boolean userCreateNumCheck(String num){
        boolean check1 = lenCheck(num);
        boolean check2 = inputCheck(num);
        boolean check3 = dupCheck(num);
        if(check1 == true || check2 == true || check3 == true){
            return true;
        }
        return false;
    }

    private boolean lenCheck(String num){
        if(num.length() != 3){
            System.out.println("3자리로 입력해주시기 바랍니다.");
            return true;
        }
        return false;
    }

    private boolean inputCheck(String num){
        if(!num.matches("^[1-9]+$")){
            System.out.println("1~9까지의 수를 입력해주시기 바랍니다.");
            return true;
        }
        return false;
    }

    private boolean dupCheck(String num){
        String[] arr = num.split("");
        String number = "";
        for(int i=0; i<arr.length; i++){
            if(number.contains(arr[i])){
                System.out.println("중복되지 않은 숫자를 입력하시기 바랍니다.");
                return true;
            }
            number += arr[i];
        }
        return false;
    }
}
