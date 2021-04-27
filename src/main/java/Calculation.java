public class Calculation {
    private int strike = 0;
    private int ball = 0;

    public Calculation (int[] balls, int userInput) {
        int[] input = intToIntArray(userInput);
        countStrike(balls, input);
        countBall(balls, input);
    }

    public int getStrike() {
        return strike;
    }

    public int[] intToIntArray(int i) {
        int len = Integer.toString(i).length();
        int[] arr = new int[len];

        for (int j = 0; j < len; j++) {
            arr[len-j-1] = i%10;
            i=i/10;
        }

        return arr;
    }

    public void countStrike(int[] balls, int[] userInput) {
        if (balls[0] == userInput[0]) {
            strike++;
        }
        if (balls[1] == userInput[1]) {
            strike++;
        }
        if (balls[2] == userInput[2]) {
            strike++;
        }
    }

    public void countBall(int[] balls, int[] userInput) {
        if (balls[0] == userInput[1] || balls[0] == userInput[2]) {
            ball++;
        }
        if (balls[1] == userInput[0] || balls[1] == userInput[2]) {
            ball++;
        }
        if (balls[2] == userInput[0] || balls[2] == userInput[1]) {
            ball++;
        }
    }

    public String getResultString() {
        StringBuilder sb = new StringBuilder();

        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }
        if (strike > 0 && strike <= 3) {
            sb.append(strike+" 스크라이크 ");
        }
        if (ball > 0) {
            sb.append(ball+" 볼");
        }

        return sb.toString();
    }
}