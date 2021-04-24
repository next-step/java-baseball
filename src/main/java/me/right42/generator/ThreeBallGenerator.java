package me.right42.generator;

import me.right42.domain.ThreeBall;

@FunctionalInterface
public interface ThreeBallGenerator {

	ThreeBall generate();
}
