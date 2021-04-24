package ui;

public class PrintOutputManager implements OutputManager {
	
	@Override
	public void print(String contents) {
		System.out.print(contents);
	}

}
