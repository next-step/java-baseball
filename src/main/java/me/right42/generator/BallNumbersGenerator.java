package me.right42.generator;

import java.util.List;

import me.right42.domain.BallNumbers;

@FunctionalInterface
public interface BallNumbersGenerator {

	BallNumbers generate();
}
