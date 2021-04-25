package domain.game;

import domain.Numbers;
import domain.participants.DefensePlayer;
import domain.participants.OffensePlayer;
import domain.participants.Umpire;

public class Game {

	private Umpire umpire;
	private DefensePlayer defensePlayer;
	private OffensePlayer offensePlayer;

	private GameStatus status;

	public Game(){
		createParticipants();
		setGameStatus(GameStatus.ONGOING);
	}

	public void setGameStatus(GameStatus status) {
		this.status = status;
	}

	private void createParticipants() {
		this.umpire = new Umpire();
		this.defensePlayer = new DefensePlayer();
		this.offensePlayer = new OffensePlayer();
	}

	public void play(){
		Numbers answer = defensePlayer.decideAnswerNumber();
		System.out.println(answer.getDigits().toString());
		while (umpire.getStrike() != Numbers.MAX_SIZE){
			umpire.requestInput();
			Numbers guess = offensePlayer.makeGuess();
			umpire.makeJudgement(answer, guess);
		}
		umpire.askAnotherRound();
		if(offensePlayer.decideWhetherContinueGame() != GameStatus.ONGOING.getCode()){
			status = GameStatus.FINISHED;
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

	public GameStatus getStatus() {
		return this.status;
	}
}
