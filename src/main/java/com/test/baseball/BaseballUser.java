package com.test.baseball;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class BaseballUser {
    private final Scanner INPUT;

    public BaseballUser(){
        INPUT = new Scanner(System.in);
    }

    public BaseballUser(InputStream is){
        INPUT = new Scanner(is);
    }

    public List<Integer> getInputNumbers() {
        List<Integer> numbers;
        do {
            System.out.print("숫자를 입력 해 주세요 : ");
            numbers = enterNumbers();
        } while( numbers == null );
        return numbers;
    }

    private List<Integer> enterNumbers() {
        String line = INPUT.nextLine();

        if (!line.matches(BaseballConstant.INPUT_REGEX)) {
            System.out.println(BaseballConstant.NUMBER_COUNT + "자리의 1-9 사이의 숫자만 입력 가능합니다");
            return null;
        }

        return parseNumbers(line);
    }

    private List<Integer> parseNumbers(String line) {
        NotDuplicateList numbers = new NotDuplicateList(BaseballConstant.NUMBER_COUNT);
        String[] temp = line.split("");

        for ( String number : temp ) {
            numbers.add(Integer.parseInt(number));
        }

        return isDuplicate(numbers)?null:numbers;
    }

    private boolean isDuplicate(NotDuplicateList list) {
        if(!list.isFull()) {
            System.out.println("중복된 숫자는 입력하실 수 없습니다");
            return true;
        }
        return false;
    }
}
