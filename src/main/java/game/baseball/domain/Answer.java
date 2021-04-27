package game.baseball.domain;

import utils.RandomUtil;
import utils.SetUtil;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Answer {
    private List<Integer> answers = new ArrayList<>();

    private Answer(int answerLength, char startNumber, char endNumber) {
        this.generateRandomAnswers(answerLength, startNumber - '0', endNumber - '0');
    }

    public static Answer init(int answerLength, char startNumber, char endNumber) {
        return new Answer(answerLength, startNumber, endNumber);
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    private void generateRandomAnswers(int answerLength, int startNumber, int endNumber) {
        // 중복 방지
        Set<Integer> numbers = new LinkedHashSet<>();

        // 게임 옵션 유효성 검증
        if (!isValidOptions(answerLength, startNumber, endNumber)) {
            System.out.println("[게임설정 오류] 입력 가능한 숫자에 비해 정답 갯수가 너무 큽니다.");
            return;
        }

        // 정답 수만큼 숫자 생성
        while (numbers.size() < answerLength) {
            numbers.add(RandomUtil.getRandomNumber(startNumber, endNumber));
        }

        // Set To List
        this.answers = SetUtil.transferSetToList(numbers);

        // 생성된 정답 출력
        printAnswers();
    }

    private boolean isValidOptions(int answerLength, int startNumber, int endNumber) {
        return answerLength <= endNumber - startNumber + 1;
    }

    public void printAnswers() {
        StringBuilder answerStringBuilder = new StringBuilder();

        for (int i = 0; i < answers.size(); i++) {
            answerStringBuilder.append(String.valueOf(answers.get(i)));
        }

        System.out.println("========================================");
        System.out.println("정답 : " + answerStringBuilder.toString());
        System.out.println("========================================");
    }

}
