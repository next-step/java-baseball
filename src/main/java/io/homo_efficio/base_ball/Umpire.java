package io.homo_efficio.base_ball;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-11-14
 */
public class Umpire {

    private final String genNumber;
    private final String inputNumber;
    private final String[] genSplit;
    private final String[] inputSplit;

    public Umpire(String genNumber, String inputNumber) {
        this.genNumber = genNumber;
        this.inputNumber = inputNumber;
        this.genSplit = genNumber.split("");
        this.inputSplit = inputNumber.split("");
    }

    public Result judge() {
        int strikes = 0, balls = 0, len = inputSplit.length;
        for (int i = 0; i < len; i++) {
            strikes = countStrikes(strikes, i);
            balls = countBalls(balls, i);
        }

        return new Result(balls, strikes, len);
    }

    private int countBalls(int balls, int i) {
        if (!genSplit[i].equals(inputSplit[i]) && genNumber.contains(inputSplit[i])) {
            balls++;
        }
        return balls;
    }

    private int countStrikes(int strikes, int i) {
        if (genSplit[i].equals(inputSplit[i])) {
            strikes++;
        }
        return strikes;
    }
}
