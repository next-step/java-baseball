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
            int indexOf = userNumbers.indexOf(quizNumber);
            if (quizNumbers.get(indexOf).equals(quizNumber)) {
                strikeNumber++;
            }
        }
        return strikeNumber;
    }
}
