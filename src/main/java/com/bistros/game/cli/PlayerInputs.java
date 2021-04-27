package com.bistros.game.cli;

import com.bistros.game.application.game.GameOperatorType;
import com.bistros.game.domain.BallNumbers;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class PlayerInputs {
    private Scanner scanner;

    public PlayerInputs() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    /**
     * 사용자로부터 새로운 게임을 시작하고 싶은지 입력을 받음
     */
    public boolean getRestartOpinion(String inputs) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Optional<GameOperatorType> inputType = GameOperatorType.fromString(inputs);

        return inputType.orElseThrow(InvalidInputException::new) == GameOperatorType.RESTART;
    }

    /**
     * 사용자로부터 받은 입력을 기반으로 List Integer 를 만듬
     *
     * @param input
     * @return
     */
    public List<Integer> getDataFromUserInput(String input) {
        if (input == null || input.length() != BallNumbers.LENGTH) {
            throw new InvalidInputException("입력하신 길이가 3글자가 아닙니다");
        }

        if (!input.matches("[1-9]+")) {
            throw new InvalidInputException("입력하신 내용이 1 ~ 9 숫자로만 이루어져있지 않습니다");
        }

        Set<Integer> set = input.chars().boxed().collect(Collectors.toSet());
        if (input.length() != set.size()) {
            throw new InvalidInputException("입력하신 숫자에 중복이 존재합니다");
        }

        return input.chars().map(c -> c - '0').boxed().collect(Collectors.toList());
    }
}
