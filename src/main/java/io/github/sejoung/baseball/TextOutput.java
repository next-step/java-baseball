package io.github.sejoung.baseball;

public class TextOutput {
	private final StringBuffer buffer = new StringBuffer();

	public TextOutput(String initialOutput) {
		buffer.append(initialOutput);
	}

	public void printMessages(String... messages) {
		buffer.append(String.join(System.lineSeparator(), messages));
	}

	public String flush() {
		String output = buffer.toString();
		buffer.setLength(0);
		return output;
	}

}
