package baseball;

public abstract class Baseball {
	
	public abstract void start();
	public abstract void play();
	public abstract boolean end();
	
	final public boolean run() {
		start();
		play();
		return end();
	};

}
