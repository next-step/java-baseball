package baseball;

import baseball.convert.BaseBallConvert;
import baseball.generate.BaseBallGenerator;
import baseball.match.BaseBallPlay;
import baseball.output.BaseBallOutput;
import baseball.validate.BaseBallValidate;

import java.util.Scanner;

public class BaseBall {
    private BaseBallGenerator generate;
    private BaseBallPlay match;
    private BaseBallConvert convert;
    private BaseBallValidate validate;
    private BaseBallOutput output;
    private String status;

    private int[] source;
    private int[] target = new int[3];

    Scanner input = new Scanner(System.in);

    public BaseBall(BaseBallGenerator generate, BaseBallPlay match, BaseBallConvert convert, BaseBallValidate validate, BaseBallOutput output) {
        this.generate = generate;
        this.match = match;
        this.convert = convert;
        this.validate = validate;
        this.output = output;
    }

    public void start() {
        this.source = generate.generate();
        output.printText("숫자를 입력해주세요 : ");
        System.out.print(this.flushOutput());
        this.play();
    }

    public void play() {
        int inputNumber = input.nextInt();

        target = convert.convert(inputNumber);

        if (validate.valid(target)) {
            Inning inning = match.play(this.source, this.target);
            output.print(inning);
            System.out.println(this.flushOutput());

            if(inning.getStrike() == 3) {
                this.finish();
            }
        }

        play();
    }

    public void finish() {
        output.printText("게임을 새로 시작하려면1, 종료하려면2를 입력하세요.");
        System.out.print(this.flushOutput());
        int replay = this.input.nextInt();

        if (replay == 1) {
            this.start();
        }

        if (replay == 2) {
            this.end();
        }
    }

    public void end() {
        output.printText("게임이 종료되었습니다.");
        System.out.print(this.flushOutput());
        System.exit(0);
    }

    public String flushOutput() {
       return output.flush();
    }
}
