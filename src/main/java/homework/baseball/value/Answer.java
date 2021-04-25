package homework.baseball.value;

public class Answer {

    private final String value;

    public Answer(String value) {
        this.value = value;
    }

    public int getBallCount(Answer answer) {
        int result = 0;
        char[] charArray = answer.value.toCharArray();
        for (int index = 0; index < charArray.length; index++) {
            int pos = this.value.indexOf(charArray[index]);
            if (pos != -1 && index != pos) {
                result++;
            }
        }
        return result;
    }

    public int getStrikeCount(Answer answer) {
        int result = 0;
        char[] charArray = answer.value.toCharArray();
        for (int index = 0; index < charArray.length; index++) {
            int pos = this.value.indexOf(charArray[index]);
            if (pos != -1 && index == pos) {
                result++;
            }
        }
        return result;
    }

    public String getHint(int strikeCount, int ballCount) {
        StringBuffer hint = new StringBuffer();
        if (strikeCount != 0) {
            hint.append(strikeCount).append(" 스트라이크").append(" ");
        }
        if (ballCount != 0) {
            hint.append(ballCount).append(" 볼");
        }
        return hint.toString();
    }

    public void printHint(Answer answer) {
        int strikeCount = getStrikeCount(answer);
        int ballCount = getBallCount(answer);
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
            return;
        }
        System.out.println(getHint(strikeCount, ballCount));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Answer) {
            Answer answer = (Answer) obj;
            return this.value.equals(answer.value);
        }
        return false;
    }

    @Override
    public String toString() {
        return value;
    }
}
