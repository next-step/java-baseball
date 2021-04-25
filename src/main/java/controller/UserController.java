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

        boolean chkNum = false;
        while(chkNum == false){
            int inputNumber = inputUserNumber();
            chkNum = generateUserNumberInfo(inputNumber);
        }

        return userNumberInfo;
    }

    public boolean generateUserNumberInfo(int inputNumber){

        inputUserNumberList(numberSeperaor(inputNumber));
        int size = CheckDuplicateUtil.checkDuplicateNumber(userNumberInfo.getUserInputNumberList());

        if(size < 3){
            return false;
        }

        return true;
    }

    private int inputUserNumber(){

        boolean numberCheck = false;
        int inputNumber = 0;
        while(numberCheck == false){
            Scanner sc = new Scanner(System.in);
            inputNumber = sc.nextInt();
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

    public static void main(String[] args) {
        UserController userController = new UserController();
        UserNumberInfo userNumberInfo1 = userController.getUserNumberInfo();

        for(int i =0; i < 3; i++){
            System.out.println(userNumberInfo1.getUserInputNumberList().get(i));
        }
    }

}
