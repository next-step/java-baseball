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
        return new Result(0, countStrikes());
    }

    private int countStrikes() {
        int strikes = 0;
        String[] genSplit = genNumber.split("");
        String[] inputSplit = inputNumber.split("");

        for (int i = 0; i < genSplit.length; i++) {
            if (genSplit[i].equals(inputSplit[i])) {
                strikes++;
            }
        }
        return strikes;
    }
}
