package template;

public abstract class BaseballTemplate {
	
	public abstract void start();
	public abstract void play();
	public abstract boolean end();
	
	final public boolean run() {
		start();
		play();
		return end();
	};

}
