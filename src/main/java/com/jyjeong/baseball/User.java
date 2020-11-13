package com.jyjeong.baseball;

import java.util.Scanner;

public class User {

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

        //TODO 숫자 여부 체크

        //TODO 숫자의 범위 체크

        //TODO 숫자의 중복여부 체크
        return number;
    }

}
