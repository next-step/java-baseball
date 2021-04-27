package com.vjerksen;

public class RandomNumber implements Number {

    Validation validation = new Validation();

    @Override
    public String generateNumber() {
        Validation validation = new Validation();
        int randNum = 0;
        int idx = 0;
        String randStringNum = "";

        for (int i = 0; i < 3; i++) {
            randNum = (int) (((Math.random() * 10) % 9) + 1);
            randStringNum = randStringNum + Integer.toString(randNum);
        }

        if (isValidate(randStringNum)) {
            return randStringNum;
        }

        return generateNumber();
    }

    @Override
    public boolean isValidate(String stringNum) {
        if (validation.chkLength(stringNum) == false) {
            return false;
        }

        if (validation.chkDuplication(stringNum) == false) {
            return false;
        }

        return true;
    }

}