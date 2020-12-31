package game;

public class Answer {
    public String answer = "";

    public Answer() {
        answer = new RandomNumberMaker().getRandomNumber();
    }

    public boolean isCorrect(String tryString) {
        int strikeCount = getStrikeCount(tryString);
        int ballCount = getBallCount(tryString);
        System.out.println(strikeCount + "스트라이크 " + ballCount + "볼");
        return strikeCount == 3;
    }

    int getStrikeCount(String tryString) {
        int result = 0;
        for (int i = 0; i < tryString.length(); i++) {
            result += answer.charAt(i) == tryString.charAt(i) ? 1 : 0;
        }
        return result;
    }

    int getBallCount(String tryString) {
        int result = 0;
        for (int i = 0; i < tryString.length(); i++) {
            result += (answer.charAt(i) != tryString.charAt(i) &&
                    answer.contains(tryString.charAt(i) + "")) ? 1 : 0;
        }
        return result;
    }
}
