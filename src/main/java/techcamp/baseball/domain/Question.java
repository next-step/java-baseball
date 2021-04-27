package techcamp.baseball.domain;

import techcamp.baseball.setting.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Question {

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    //==생성 메서드==//
    public Question() {
        this.numbers = generatedNumbers();
    }

    public Question(List<Integer> numbers) {
        this.numbers = numbers;
    }

    //==비즈니스 메서드==//
    private List<Integer> generatedNumbers() {
        List<Integer> newNumbers = new ArrayList<>();
        Random random = new Random();

        while (newNumbers.size() < Config.NUMBERS_LENGTH) {
            addNumber(newNumbers, random.nextInt(Config.NUMBERS_MAX) + Config.NUMBERS_MIN);
        }

        return newNumbers;
    }

    private void addNumber(List<Integer> newNumbers, int number) {
        if (!newNumbers.contains(number)) {
            newNumbers.add(number);
        }
    }
}
