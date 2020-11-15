package exam.baseball;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface Game {

	void start();
	
	void setInputMethod(Supplier<String> inputMethod);
	void setPrintMethod(Consumer<String> printMethod);
}
