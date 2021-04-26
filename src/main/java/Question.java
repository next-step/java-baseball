import java.util.*;

public class Question {

    private List<Integer> questions;

    public Question() {
        makeQuestion();
    }

    public Question(List<Integer> questions) {
        this.questions = questions;
    }

    public List<Integer> getQuestions() {
        return questions;
    }

    private void makeQuestion() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(list);

        questions = new ArrayList<>(3);
        questions.add(list.get(0));
        questions.add(list.get(1));
        questions.add(list.get(2));
    }

    public JudgeResult judge(String answer) {
        List<Integer> answerList = new ArrayList<>();

        int answerNumber = Integer.parseInt(answer);
        answerList.add(answerNumber / 100);
        answerList.add((answerNumber % 100) / 10);
        answerList.add(answerNumber % 10);

        return judge(answerList);
    }

    public JudgeResult judge(List<Integer> answer) {
        JudgeResult judgeResult = new JudgeResult();
        for (int i = 0; i < 3; i++) {
            judgeResult.judgeEach(questions, i, answer.get(i));
        }
        return judgeResult;
    }
}
