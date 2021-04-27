package com.vjerksen;

import java.util.Scanner;

public class InputNumber implements Number {

    Validation validation = new Validation();

    @Override
    public String generateNumber() {
        Validation validation = new Validation();
        Scanner sc = new Scanner(System.in);
        String inputStringNum = "";

        inputStringNum = (String) sc.next();
        if (isValidate(inputStringNum)) {
            return inputStringNum;
        }

        return generateNumber();
    }

    @Override
    public boolean isValidate(String stringNum) {
        if (validation.chkLength(stringNum) == false) {
            System.out.println("세 자리 숫자를 다시 입력해주세요.");
            return false;
        }

        if (validation.chkDuplication(stringNum) == false) {
            System.out.println("숫자 내에 중복된 숫자가 존재합니다. 다시 입력해주세요.");
            return false;
        }

        return true;
    }
}
