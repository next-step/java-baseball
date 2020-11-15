package domain;

import java.util.Random;

public class Com {
    private Integer integer;
    private Integer integer1;
    private Integer integer2;

    public Com() {
    }

    public Com(Integer integer, Integer integer1, Integer integer2) {
        this.integer = integer;
        this.integer1 = integer1;
        this.integer2 = integer2;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public void setInteger1(Integer integer1) {
        this.integer1 = integer1;
    }

    public void setInteger2(Integer integer2) {
        this.integer2 = integer2;
    }

    public String output() {
        return String.valueOf(this.integer +this.integer1 +this.integer2);
    }
}
