package com.vjerksen;

import java.util.Scanner;

public class InputNumber implements Number {

    @Override
    public String generateNumber() {
        Validation validation = new Validation();
        Scanner sc = new Scanner(System.in);
        String inputStringNum = "";

        inputStringNum = (String) sc.next();
        if (validation.isValidate(inputStringNum)) {
            return inputStringNum;
        }

        return generateNumber();
    }

}
