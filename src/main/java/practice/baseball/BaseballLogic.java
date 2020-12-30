package practice.baseball;

public class BaseballLogic {

    private String number;

    public void setNumbers() {
        this.number = "";
        number += Integer.toString( (int) ((Math.random()*10000) % 9) + 1 );
        number += Integer.toString( (int) ((Math.random()*10000) % 9) + 1 );
        number += Integer.toString( (int) ((Math.random()*10000) % 9) + 1 );
    }


}
