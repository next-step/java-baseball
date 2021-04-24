package domain;

public class Game {

	private Umpire umpire;
	private DefensePlayer defensePlayer;
	private OffensePlayer offensePlayer;
	private Status status;

	public Game(){
		createParticipants();
		setGameStatus(Status.ONGOING);
	}

	private void setGameStatus(Status ongoing) {
		this.status = ongoing;
	}

	private void createParticipants() {
		this.umpire = new Umpire();
		this.defensePlayer = new DefensePlayer();
		this.offensePlayer = new OffensePlayer();
	}

	public void play(){
		Numbers answer = defensePlayer.decideAnswerNumber();
		while(status == Status.ONGOING){
			umpire.requestInput();
			offensePlayer.makeGuess();
		}

	}

	public enum Status{
		ONGOING(1),
		FINISHED(0);

		private int status;

		Status(int status){
			this.status = status;
		}
	}


	public Umpire getUmpire(){
		return this.umpire;
	}

	public DefensePlayer getDefensePlayer() {
		return this.defensePlayer;
	}

	public OffensePlayer getOffensePlayer() {
		return this.offensePlayer;
	}

	public Status getStatus() {
		return this.status;
	}
}
