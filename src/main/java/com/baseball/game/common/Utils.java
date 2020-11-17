package com.baseball.game.common;

import com.baseball.game.exception.BaseBallException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
    public static int inputNumber(){
        Scanner sc = new Scanner(System.in);
        try{
            return sc.nextInt();
        }catch (InputMismatchException e){
            throw new BaseBallException("숫자를 입력해 주세요");
        }
    }

    public static void isNumberRange(int offset, int limit, int input){
        if(input < offset || input > limit){
            throw new BaseBallException(String.format("%d ~ %d 사이의 숫자만 입력해 주세요", offset, limit));
        }
    }
}
