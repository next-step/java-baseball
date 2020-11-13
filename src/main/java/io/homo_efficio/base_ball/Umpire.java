package io.homo_efficio.base_ball;

/**
 * @author homo.efficio@gmail.com
 * created on 2020-11-14
 */
public class Umpire {

    private String genNumber;
    private String inputNumber;

    public Umpire(String genNumber, String inputNumber) {
        this.genNumber = genNumber;
        this.inputNumber = inputNumber;
    }

    public Result judge() {
        int strikes = 0, balls = 0;
        String[] genSplit = genNumber.split("");
        String[] inputSplit = inputNumber.split("");

        return getResult(strikes, balls, genSplit, inputSplit);
    }

    private Result getResult(int strikes, int balls, String[] genSplit, String[] inputSplit) {
        for (int i = 0; i < inputSplit.length; i++) {
            strikes = countStrikes(strikes, genSplit, inputSplit, i);
            balls = countBalls(balls, genSplit, inputSplit, i);
        }

        return new Result(balls, strikes);
    }

    private int countBalls(int balls, String[] genSplit, String[] inputSplit, int i) {
        if (!genSplit[i].equals(inputSplit[i]) && genNumber.contains(inputSplit[i])) {
            balls++;
        }
        return balls;
    }

    private int countStrikes(int strikes, String[] genSplit, String[] inputSplit, int i) {
        if (genSplit[i].equals(inputSplit[i])) {
            strikes++;
        }
        return strikes;
    }
}
