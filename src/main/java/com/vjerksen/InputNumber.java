package com.vjerksen;

import java.util.Scanner;

public class InputNumber implements Number {

    @Override
    public String generateNumber() {
        Scanner sc = new Scanner(System.in);
        String inputStringNum = "";

        inputStringNum = (String) sc.next();
        if(chkValidate(inputStringNum)) {
            return inputStringNum;
        }

        return generateNumber();
    }

    @Override
    public boolean chkValidate(String inputStringNum) {
        Validation validation = new Validation();

        if(validation.chkLength(inputStringNum) == false) {
            return false;
        }

        if(validation.chkDuplicate(inputStringNum) == false) {
            return false;
        }

        return true;
    }

}
