package ui;

public class PrintOutputManager implements OutputManager {
	
	private static OutputManager outputManager = new PrintOutputManager();
	private PrintOutputManager() {}
	
	public static OutputManager getInstance() {
		return outputManager;
	}
	
	@Override
	public void print(String contents) {
		System.out.print(contents);
	}

}
