package baseball;

public class Referee {

    private int strike = 0;
    private int ball = 0;
    private SlicedNumberVo slicedTargetNumberVo;

    public Referee(int computerNumber) {
        slicedTargetNumberVo = new SlicedNumberVo(computerNumber);
    }


    boolean isPlayerWin(int userNumber) {
        initialize();
        SlicedNumberVo slicedUserNumberVo = new SlicedNumberVo(userNumber);
        judgeStrike(slicedTargetNumberVo, slicedUserNumberVo);
        judgeBall(slicedTargetNumberVo, slicedUserNumberVo);
        if (isPlayerWin()) {
            System.out.println("유저 승");
            return true;
        }
        if (judgeNothing()) System.out.println("낫싱");
        if (!judgeNothing()) System.out.println(String.format("%s 스트라이크 / %s 볼", strike, ball));
        return false;
    }

    private void initialize() {
        this.strike = 0;
        this.ball = 0;
    }


    private void judgeStrike(SlicedNumberVo slicedTargetNumberVo, SlicedNumberVo slicedUserNumberVo) {
        if (slicedTargetNumberVo.getHundred() == slicedUserNumberVo.getHundred()) {
            this.strike++;
        }
        if (slicedTargetNumberVo.getTens() == slicedUserNumberVo.getTens()) {
            this.strike++;
        }
        if (slicedTargetNumberVo.getUnit() == slicedUserNumberVo.getUnit()) {
            this.strike++;
        }
    }

    private void judgeBall(SlicedNumberVo slicedTargetNumberVo, SlicedNumberVo slicedUserNumberVo) {
        if (slicedTargetNumberVo.getHundred() != slicedUserNumberVo.getHundred() && (slicedUserNumberVo.getHundred() == slicedTargetNumberVo.getTens() || slicedUserNumberVo.getHundred() == slicedTargetNumberVo.getUnit())) {
            this.ball++; //백의자리가 서로 일치하지 않고 유저입력값의 백의자리 숫자가 십의자리 숫자나 일의자리 숫자와 일치하면 ball++
        }
        if (slicedTargetNumberVo.getTens() != slicedUserNumberVo.getTens() && (slicedUserNumberVo.getTens() == slicedTargetNumberVo.getHundred() || slicedUserNumberVo.getTens() == slicedTargetNumberVo.getUnit())) {
            this.ball++; //십의자리가 서로 일치하지 않고 유저입력값의 십의자리 숫자가 백의자리 숫자나 일의자리 숫자와 일치하면 ball++
        }
        if (slicedTargetNumberVo.getUnit() != slicedUserNumberVo.getUnit() && (slicedUserNumberVo.getUnit() == slicedTargetNumberVo.getHundred() || slicedUserNumberVo.getUnit() == slicedTargetNumberVo.getTens())) {
            this.ball++; //일의자리가 서로 일치하지 않고 유저입력값의 일의자리 숫자가 백의자리 숫자나 십의자리 숫자와 일치하면 ball++
        }
    }

    private boolean judgeNothing() {
        return this.strike == 0 && this.ball == 0;
    }

    private boolean isPlayerWin() {
        return this.strike == 3;
    }

    public void setComputerNumber(int computerNumber) {
        this.slicedTargetNumberVo = new SlicedNumberVo(computerNumber);
    }


    private class SlicedNumberVo {
        private int hundred;
        private int tens;
        private int unit;

        private SlicedNumberVo() { //prevent default constructor

        }

        private SlicedNumberVo(int number) {
            this.hundred = number / 100;
            this.tens = (number % 100) / 10;
            this.unit = (number % 10);
        }

        int getHundred() {
            return hundred;
        }

        int getTens() {
            return tens;
        }

        int getUnit() {
            return unit;
        }
    }
}
