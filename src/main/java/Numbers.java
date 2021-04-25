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
            strikeNumber = getStrikeNumber(userNumbers, strikeNumber, quizNumber);
        }
        return strikeNumber;
    }

    private int getStrikeNumber(List<Integer> userNumbers, int strikeNumber, Integer quizNumber) {
        int indexOf = userNumbers.indexOf(quizNumber);
        if (indexOf != -1 && quizNumbers.get(indexOf).equals(quizNumber)) {
            strikeNumber++;
        }
        return strikeNumber;
    }
}
