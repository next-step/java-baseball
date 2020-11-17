package com.leeha.baseball.controller.generator;

@FunctionalInterface
public interface BallConditionPredicate<T> {

    boolean test(T t);
}
