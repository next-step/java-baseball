import java.util.List;

public class Numbers {
    private final List<Integer> gameNumbers;
    private final List<Integer> quizNumbers;

    public Numbers(List<Integer> gameNumbers) {
        this.gameNumbers = gameNumbers;
        this.quizNumbers = gameNumbers.subList(0, 3);
    }

    public int size() {
        return this.gameNumbers.size();
    }

    public int strike(List<Integer> userNumbers) {
        int strikeNumber = 0;
        for (Integer quizNumber : quizNumbers) {
            strikeNumber += strikeNumber(userNumbers, quizNumber);
        }
        return strikeNumber;
    }

    public int ball(List<Integer> userNumbers) {
        int ballNumber = 0;
        for (Integer quizNumber : quizNumbers) {
            ballNumber += ballNumber(userNumbers, quizNumber);
        }
        return ballNumber;
    }

    private int ballNumber(List<Integer> userNumbers, Integer quizNumber) {
        int ballNumber = 0;
        int userNumberIndex = userNumbers.indexOf(quizNumber);
        if (userNumberIndex != -1 && !quizNumbers.get(userNumberIndex).equals(quizNumber)) {
            ballNumber++;
        }
        return ballNumber;
    }

    private int strikeNumber(List<Integer> userNumbers, Integer quizNumber) {
        int strikeNumber = 0;
        int userNumberIndex = userNumbers.indexOf(quizNumber);
        if (userNumberIndex != -1 && quizNumbers.get(userNumberIndex).equals(quizNumber)) {
            strikeNumber++;
        }
        return strikeNumber;
    }
}
