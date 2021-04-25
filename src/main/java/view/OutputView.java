package view;

import number.NumbersMatchResult;

public interface OutputView {
	void printInputNumberMessage();

	void printNumbersMatchResult(NumbersMatchResult numbersMatchResult,
								NumberMatchResultRenderer numberMatchResultRenderer);

	void printEndGameMessage(int numberLength);

	void printRerunGameMessage(String rerunFlag, String endFlag);
}
