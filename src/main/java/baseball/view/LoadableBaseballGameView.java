package baseball.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import baseball.constant.MessageContainer;

public class LoadableBaseballGameView extends BaseballGameView {
	public static final String fileName = "history.txt";
	private PrintStream saveFile;
	private Scanner scanner;
	private boolean load;

	public LoadableBaseballGameView() throws FileNotFoundException {
	 	scanner = new Scanner(new FileInputStream(fileName));
	 	if (!scanner.hasNextLine()) {
	 		scanner = null;
		}
		setWriter(true);
	}

	@Override
	public String readInput() {
		if (!isLoad()) {
			load = true;
			return scanner.nextLine();
		}

		if (null != scanner && scanner.hasNextLine()) {
			return readInputFromSaveFile();
		}

		String input = super.readInput();
		saveFile.println(input);
		return input;
	}

	private String readInputFromSaveFile() {
		String input = scanner.nextLine();
		outputWriter.print(MessageContainer.INPUT_MESSAGE);
		outputWriter.println(input);
		return input;
	}

	private void setWriter(boolean append) {
		try {
			this.saveFile = new PrintStream(new FileOutputStream(fileName,append), true);
		} catch (FileNotFoundException e) {
			this.saveFile = new PrintStream(new EmptyOutputStream());
		}
	}

	@Override
	public void clearView() {
		super.clearView();
		setWriter(false);
	}

	public static class EmptyOutputStream extends OutputStream {

		@Override
		public void write(int b) throws IOException {

		}
	}

	public boolean isLoad() {
		return load;
	}

	@Override
	public PrintStream getOutputWriter() {
		return saveFile;
	}
}
