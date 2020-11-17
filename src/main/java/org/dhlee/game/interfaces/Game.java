package org.dhlee.game.interfaces;

public interface Game<T> {
	void init();

	void start();

	T stop();
}
