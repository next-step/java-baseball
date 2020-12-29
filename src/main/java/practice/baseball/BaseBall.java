package practice.baseball;

import practice.javabasic.JavaBasic;

public class BaseBall {

    public static void main(String[] args) {
        BaseBall baseballObj = new BaseBall();

        do {
            String number = baseballObj.getNumbers();


        } while(true);

    }

    private String getNumbers() {
        String number = "";
        number += Integer.toString( (int) ((Math.random()*10000) % 9) + 1 );
        number += Integer.toString( (int) ((Math.random()*10000) % 9) + 1 );
        number += Integer.toString( (int) ((Math.random()*10000) % 9) + 1 );
        return number;
    }

}
