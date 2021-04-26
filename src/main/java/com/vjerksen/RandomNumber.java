package com.vjerksen;

public class RandomNumber implements Number{

    @Override
    public String generateNumber() {
        int randNum = 0;
        int idx = 0;
        String randStringNum = "";

        for (int i = 0; i < 3; i++) {
            randNum = (int) (((Math.random() * 10) % 9) + 1);
            randStringNum = randStringNum + Integer.toString(randNum);
        }

        if(chkValidate(randStringNum)){
            return randStringNum;
        }

        return generateNumber();
    }

    @Override
    public boolean chkValidate(String randStringNum) {
        Validation validation = new Validation();

        if(validation.chkLength(randStringNum) == false) {
            return false;
        }

        if(validation.chkDuplicate(randStringNum) == false) {
            return false;
        }

        return true;
    }
}
