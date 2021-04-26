import questionnumber.QuestionInterface;
import questionnumber.QuestionNumber;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private QuestionInterface questionInterface;
    private QuestionNumber questionNumber;
    private Referee referee;

    public BaseballGame(QuestionInterface questionInterface) {
        this.questionInterface = questionInterface;
        this.referee = new Referee();
    }

    public void setQuestionNumber() {
        this.questionNumber = questionInterface.setQuestionNumber();
    }

    public void checkPresentationNumber(String presentationNumberWithString) {
        List<Integer> presentationNumber = this.stringConverterToIntegerList(presentationNumberWithString);

        // when
        for (int index = 0; index < presentationNumber.size(); index++) {
            this.getReferee().countStrike(questionNumber.getQuestionNumber().get(index), presentationNumber.get(index));
            this.getReferee().countBalls(questionNumber.getQuestionNumber(), index, presentationNumber.get(index));
        }
    }

    /**
     * String converter To Integer List
     * @param presentationNumberWithString
     * @return
     */
    private List<Integer> stringConverterToIntegerList(String presentationNumberWithString) {
        List<Integer> presentationNumber = new ArrayList<>();

        String [] presentationNumberWithStringArray = presentationNumberWithString.split("");

        for (int i=0; i < presentationNumberWithStringArray.length; i++) {
            presentationNumber.add(Integer.valueOf(presentationNumberWithStringArray[i]));
        }

        return presentationNumber;
    }

    public Referee getReferee() {
        return referee;
    }
}
