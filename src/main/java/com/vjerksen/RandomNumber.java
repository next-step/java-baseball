package com.vjerksen;

public class RandomNumber implements Number {

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

        if (validation.isValidate(randStringNum)) {
            return randStringNum;
        }

        return generateNumber();
    }

}