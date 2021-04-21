package baseball.domain;

import baseball.exception.InvalidateBallNumberException;
import baseball.exception.InvalidateBallNumberException.InvalidateBallNumberSizeError;
import baseball.exception.InvalidateBallNumberException.InvalidateBallNumberValueError;

import java.util.*;

public class BallNumber {

    private final static int NUMBER_SIZE = 3;
    private final static int NUMBER_MAX_VALUE = 9;
    private final static int NUMBER_MIN_VALUE = 1;

    private LinkedHashSet<Integer> numbers;

    public BallNumber() {
        this.numbers = new LinkedHashSet<>();
        Random random = new Random();
        while(this.numbers.size() != NUMBER_SIZE)
            this.numbers.add(random.nextInt(NUMBER_MAX_VALUE) + 1);
    }

    public BallNumber(int baseballNumbers) throws InvalidateBallNumberException {
        this.numbers = new LinkedHashSet<>();
        inputBaseBall(baseballNumbers);
        validate();
    }

    private void inputBaseBall(int baseballNumbers){
        String[] splitBaseballNumbers = String.valueOf(baseballNumbers).split("");
        for(int index = 0; index < splitBaseballNumbers.length; index ++ )
            this.numbers.add(Integer.parseInt(splitBaseballNumbers[index]));
    }

    private void validate() {
        sizeValidate();
        Iterator<Integer> numbersIterator = this.numbers.iterator();
        while(numbersIterator.hasNext())
            valueValidate(numbersIterator.next());
    }

    private void sizeValidate() {
        if(this.numbers.size() != NUMBER_SIZE)
            throw new InvalidateBallNumberSizeError( "Size : " + this.numbers.size());
    }

    private void valueValidate(int number) {
        if (number > NUMBER_MAX_VALUE || number < NUMBER_MIN_VALUE)
            throw new InvalidateBallNumberValueError("Ball Numbers : " + number);
    }

    public int getNumberByIndex(int index){
        List<Integer> listNumbers = new ArrayList(this.numbers);
        return listNumbers.get(index);
    }

    @Override
    public String toString() {
        String ballNumberString = "";
        Iterator<Integer> numbersIterator = this.numbers.iterator();
        while(numbersIterator.hasNext())
            ballNumberString += numbersIterator.next();
        return ballNumberString;
    }
}
