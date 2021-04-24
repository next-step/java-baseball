import number.IllegalNumberException;

public class NumberBaseballGame {

	private final View view;

	public NumberBaseballGame(View view) {
		this.view = view;
	}

	public void run() {
		view.inputNumbers();
	}

	public static void main(String[] args) {
		View view = new View(System.in);
		NumberBaseballGame numberBaseballGame = new NumberBaseballGame(view);
		try {
			numberBaseballGame.run();
		} catch (IllegalNumberException e) {
			e.printStackTrace();
		}
	}
}
