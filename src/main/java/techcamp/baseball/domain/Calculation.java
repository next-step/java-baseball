package techcamp.baseball.domain;

public class Calculation {

    public void execute(Question question, Answer answer) {
        for (int i = 0; i < answer.getNumbers().size(); i++) {
            calculateResult(i, question, answer);
        }
    }

    private void calculateResult(int i, Question question, Answer answer) {
        int questionNumber = question.getNumbers().get(i);
        int answerNumber = answer.getNumbers().get(i);
        if(question.getNumbers().contains(answerNumber)) {
            answer.addBall();
        }
        if (questionNumber == answerNumber) {
            answer.removeBall();
            answer.addStrike();
        }
    }
}
