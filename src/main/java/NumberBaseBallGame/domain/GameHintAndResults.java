package NumberBaseBallGame.domain;

import java.util.Map;
import java.util.Set;

public class GameHintAndResults {
	private boolean finish;
	private String hint;

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}
}
