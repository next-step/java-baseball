package me.right42.generator;

import me.right42.domain.BallNumbers;

@FunctionalInterface
public interface BallNumbersGenerator {

	BallNumbers generate();
}
