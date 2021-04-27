package controller;

import domain.UserNumberInfo;
import util.CheckDuplicateUtil;
import util.UserNumberUtil;

import java.util.Scanner;

public class UserController {

    private UserNumberInfo userNumberInfo;

    public UserController(){
        userNumberInfo = new UserNumberInfo();
    }

    public UserNumberInfo getUserNumberInfo(){

        return userNumberInfo;
    }

    public void makeUserNumberInfo(){
        boolean chkNum = false;
        while(chkNum == false){
            int inputNumber = inputUserNumber();
            chkNum = generateUserNumberInfo(inputNumber);
        }
    }

    public boolean generateUserNumberInfo(int inputNumber){

        inputUserNumberList(numberSeperaor(inputNumber));
        return CheckDuplicateUtil.checkDuplicateNumber(userNumberInfo.getUserInputNumberList());
    }

    private int inputUserNumber(){

        boolean numberCheck = false;
        int inputNumber = 0;
        while(numberCheck == false){
            System.out.print("숫자를 입력해주세요 : ");
            inputNumber = UserNumberUtil.inputUserNumber();
            numberCheck = UserNumberUtil.checkNumberDigit(inputNumber);
        }

        return inputNumber;
    }

    private int[] numberSeperaor(int inputNumber){

        int[] intArr = new int[3];
        int position = 2;
        while(inputNumber > 10){
            intArr[position--] = inputNumber % 10;
            inputNumber /= 10;
        }
        intArr[position] = inputNumber;

        return intArr;
    }

    private void inputUserNumberList(int[] numberArr){

        userNumberInfo.getUserInputNumberList().clear();
        for(int i = 0; i < 3; i++){
            userNumberInfo.setUserInputNumber(numberArr[i]);
        }

    }

}
