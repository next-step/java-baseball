package baseball.controller;

import baseball.domain.Numbers;
import baseball.view.input.Input;
import baseball.view.output.Output;

import java.util.*;

public class GameController {
    private final Input input;
    private final Output output;
    private final int numberSize;
    private final int ZERO = 0;
    private Numbers randomNumbers;

    public GameController(final Input input, final Output output, final int numberSize) {
        this.input = input;
        this.output = output;
        this.numberSize = numberSize;
        this.randomNumbers = getRandomNumbers();
    }

    public void start() {
        System.out.println("computer" + randomNumbers);
    }

    public void reStart() {
        randomNumbers = getRandomNumbers();
        start();
    }

    private Numbers getNumbers() {
        final List<String> numbers = input.getNumbers();
        validate(numbers);
        return new Numbers(numbers);
    }

    private void validate(final List<String> numbers) {
        if (validateSize(numbers) || validateDuplicate(numbers)) {
            getNumbers();
        }
    }

    private boolean validateSize(List<String> numbers) {
        return numbers.size() != numberSize;
    }

    private boolean validateDuplicate(List<String> numbers) {
        return new HashSet<>(numbers).size() != numberSize;
    }

    private Numbers getRandomNumbers() {
        final List<String> sampleNumbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        Collections.shuffle(sampleNumbers);
        final List<String> takenNumbers = take(sampleNumbers, numberSize);
        return new Numbers(takenNumbers);
    }

    private List<String> take(final List<String> arr, final int limit) {
        final List<String> arrayList = new ArrayList<>();
        for (int i = ZERO; i < limit; i++) {
            arrayList.add(arr.get(i));
        }
        return arrayList;
    }

}
