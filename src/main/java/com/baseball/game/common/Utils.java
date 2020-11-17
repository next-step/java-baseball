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
}
