package domain;

import java.util.Random;

public class Com {
    private Random rn;
    private Integer integer;
    private Integer integer1;
    private Integer integer2;

    public Com() {
        integer = 0;
        integer1 = 0;
        integer2 = 0;
        this.rn = new Random();;
    }

    public Com invoke() {
        while(!((integer2 / 100) != integer1 | (integer2 / 100) != integer | (integer1 / 10) != integer)){
            integer = 1 * (rn.nextInt(9) + 1);
            integer1 = 10 * (rn.nextInt(9) + 1);
            integer2 = 100 * (rn.nextInt(9) + 1);
        }
        return this;
    }

    public String output() {
        return String.valueOf(this.integer +this.integer1 +this.integer2);
    }
}
