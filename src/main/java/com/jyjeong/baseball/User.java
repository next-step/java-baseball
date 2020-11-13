package com.jyjeong.baseball;

import java.util.Scanner;

public class User {

    NumberCheck numberCheck = new NumberCheck();

    /**
     * 사용자의 값 입력받는 함수
     */
    public int[] userNumber(){
        Scanner scan = new Scanner(System.in);
        int[] userNumber;


        System.out.print("숫자를 입력해주세요 : ");
        userNumber  = validate(scan.nextLine());

        return userNumber;
    }

    /**
     * 입력받은 값의 정합성을 체크한후 int array로 반환
     */
    public int[] validate(String data){
        int[] number = new int[3];

        if(!numberCheck.numberCheck(data)){
            throw new RuntimeException("입력된 값이 숫자가 아닙니다");
        }

        if(!numberCheck.lengthCheck(data)){
            throw new RuntimeException("입력된 값의 범위가 초과 되었습니다.");
        }

        number = stringToIntArray(data);

        if(!numberCheck.uniqueCheck(number)){
            throw new RuntimeException("입력된 값중 중복된 값이 있습니다");
        }
        return number;
    }

    public int[] stringToIntArray(String data){
        int[] userNumber = new int[3];
        for(int i = 0 ; i < data.length() ; i++){
            userNumber[i] = Character.digit(data.charAt(i),10);
        }
        return userNumber;
    }
}
