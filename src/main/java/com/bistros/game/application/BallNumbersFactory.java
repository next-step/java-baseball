package com.bistros.game.application;

import com.bistros.game.domain.ball.BallNumbers;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class BallNumbersFactory {


    private Random random;

    public BallNumbersFactory(Random random) {
        this.random = random;
    }

    public BallNumbers generate() {
        final List<Integer> GAME_CHARS = IntStream.range(1, 9).boxed().collect(toList());
        Collections.shuffle(GAME_CHARS, random);
        return new BallNumbers(GAME_CHARS.subList(0, BallNumbers.LENGTH));
    }
}
