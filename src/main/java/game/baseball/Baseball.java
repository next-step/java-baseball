package game.baseball;

import game.Game;
import game.baseball.vo.Answer;
import game.baseball.answer.AnswerChecker;
import utils.random.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static game.baseball.constant.BaseballConfig.*;

public class Baseball implements Game {
    @Override
    public void start() {
        System.out.println("BaseBall Game Start!!!");

        List<Integer> randomNumberList
                = RandomGenerator.integerListGeneratorNotDuplicate(ANSWER_COUNT, ANSWER_NUMBER_MIN, ANSWER_NUMBER_MAX);
        Answer answer = new Answer(randomNumberList);

        List<Integer> inputNumberList;
        do {
            inputNumberList = getInputNumber();
        } while (!AnswerChecker.checkAnswer(answer, inputNumberList));

        System.out.println(ANSWER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private List<Integer> getInputNumber() {
        List<Integer> inputNumberList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력주세요 : ");

        try {
            for (String str : sc.next().split("")) {
                inputNumberList.add(Integer.parseInt(str));
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 값이 입력되었습니다.");
            return Collections.emptyList();
        }
        return inputNumberList;
    }
}
